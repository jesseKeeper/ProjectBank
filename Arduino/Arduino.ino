#include <SPI.h>
#include <MFRC522.h>

#define SS_PIN 10
#define RST_PIN 9
MFRC522 mfrc522(SS_PIN, RST_PIN);
MFRC522::MIFARE_Key key;
byte index;

// Change te block where the bank number is stored.
int block = 1;

byte readBackBlock[16];

void setup() {
  Serial.begin(9600);
  SPI.begin();
  mfrc522.PCD_Init();

  Serial.println("Please scan your card...");
}

void loop() {
  if (!mfrc522.PICC_IsNewCardPresent()) {
    return;
  }

  if (!mfrc522.PICC_ReadCardSerial()) {
    return;
  }

  readBlock(block, readBackBlock);
  //Show UID on serial monitor
  String UID = "";
  Serial.print("UID tag :");
  byte letter;
  for (byte i = 0; i < mfrc522.uid.size; i++) {
    Serial.print(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " ");
    Serial.print(mfrc522.uid.uidByte[i], HEX);
    UID.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
    UID.concat(String(mfrc522.uid.uidByte[i], HEX));
  }
  Serial.println("");
  Serial.println("");
}

void readBlock(int blockNumber, byte arrayAddress[]) {
  authenticateBlockAction(block);

  byte buffersize = 18;

  byte status = mfrc522.MIFARE_Read(blockNumber, arrayAddress, &buffersize); \
  if (status != MFRC522::STATUS_OK) {
    Serial.println("Read failed");
    return;
  }

  // Set authentication key
  for (index = 0; index < 6; index++) {
    key.keyByte[index] = 0xFF;
  }

  String content = "";
  for (int index = 0; index < sizeof(readBackBlock); index++) {
    content += char(readBackBlock[index]);
  }
  Serial.println(content);

  // End authentication
  mfrc522.PICC_HaltA();
  mfrc522.PCD_StopCrypto1();
}

void authenticateBlockAction(int blockNumber) {
  int largestModulo4Number = blockNumber / 4 * 4;
  int trailerBlock = largestModulo4Number + 3;

  byte status = mfrc522.PCD_Authenticate(MFRC522::PICC_CMD_MF_AUTH_KEY_A, trailerBlock, &key, &(mfrc522.uid));
  if (status != MFRC522::STATUS_OK) {
    Serial.println("Authentication failed");
    return;
  }
}