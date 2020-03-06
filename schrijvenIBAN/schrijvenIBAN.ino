/* This code is used to write a bank number to a RFID card, on a specified block.

   Created by   Rudy Schlaf for www.makecourse.com
   DATE:    2/2014

   Edited by    Groep 3B Project 3-4

   Pin layout:
   SDA  -> 10
   SCK  -> 13
   MOSI -> 11
   MISO -> 12
   IRQ  -> NC
   GND  -> GND
   RST  -> 9
   3.3V -> 3.3V
*/

#include <SPI.h>
#include <MFRC522.h>

#define SS_PIN 10
#define RST_PIN 9
MFRC522 mfrc522(SS_PIN, RST_PIN);
MFRC522::MIFARE_Key key;
byte index;

// Change te block where the bank number is stored.
int block = 1;

// Change the bank number that will be written to the block.
byte blockContent[16] = {"TEST 12 3456789"};

byte readBackBlock[15];

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

  // Set authentication key
  for (index = 0; index < 6; index++) {
    key.keyByte[index] = 0xFF;
  }

  Serial.println("Card selected");

  // Write the block
  writeBlock(block, blockContent);
  readBlock(block, readBackBlock);

  // End authentication
  mfrc522.PICC_HaltA();
  mfrc522.PCD_StopCrypto1();
}
void writeBlock(int blockNumber, byte arrayAddress[]) {
  authenticateBlockAction(block);

  if (blockNumber > 2 && (blockNumber + 1) % 4 == 0) {
    return;
  }

  byte status = mfrc522.MIFARE_Write(blockNumber, arrayAddress, 16);
  if (status != MFRC522::STATUS_OK) {
    Serial.println("Write failed");
    return;
  }

  Serial.println("Block was written");
}

void readBlock(int blockNumber, byte arrayAddress[]) {
  authenticateBlockAction(block);

  byte buffersize = 18;

  byte status = mfrc522.MIFARE_Read(blockNumber, arrayAddress, &buffersize); \
  if (status != MFRC522::STATUS_OK) {
    Serial.println("Read failed");
    return;
  }

  for (byte index = 0; index < 6; index++) {
    key.keyByte[index] = 0xFF;
  }

  String content = "";
  for (int index = 0; index < sizeof(readBackBlock); index++) {
    content += char(readBackBlock[index]);
  }
  Serial.println(content);
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
