// De keypad instellingen
#include <Keypad.h> 

const byte ROWS = 4; 
const byte COLS = 4; 

char keys[ROWS][COLS] = {
{'1','2','3','A'},
{'4','5','6','B'},
{'7','8','9','C'},
{'*','0','#','D'}
};

byte rowPins[ROWS] = { A0, A1, A2, A3}; //links naar rechts A0-A3, A4-A7
byte colPins[COLS] = { A4, A5, 6, 7};
String Key; 
String cUID = "";

Keypad keypad = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );

// De RFID instellingen
#include <SPI.h>
#include <MFRC522.h>

#define SS_PIN 10
#define RST_PIN 9
MFRC522 mfrc522(SS_PIN, RST_PIN);
MFRC522::MIFARE_Key key;

String content = "";
byte index; 
int block = 1;
byte readBackBlock[15];

void setup() {
  Serial.begin(9600);   
  SPI.begin();      
  keypad.addEventListener(keypadEvent); 
  mfrc522.PCD_Init(); 
}

void keypadEvent(KeypadEvent eKey){
  switch (keypad.getState()){
    case PRESSED:
      delay(10);  
  }
} 
    
void getUID(){
  content= "";
  byte letter;
  for (byte i = 0; i < mfrc522.uid.size; i++){
     content.concat(String(mfrc522.uid.uidByte[i] < 0x10 ? " 0" : " "));
     content.concat(String(mfrc522.uid.uidByte[i], HEX));
  }
  content.toUpperCase();
}

void authenticateBlockAction(int blockNumber){
    int largestModulo4Number = blockNumber / 4 * 4;
    int trailerBlock = largestModulo4Number + 3;

    byte status = mfrc522.PCD_Authenticate(MFRC522::PICC_CMD_MF_AUTH_KEY_A, trailerBlock, &key, &(mfrc522.uid));
    if (status != MFRC522::STATUS_OK) {
        Serial.println("Authentication failed");
        return;
    }
}

void readBlock(int blockNumber, byte arrayAddress[]){
    authenticateBlockAction(block);

    byte buffersize = 18;

    byte status = mfrc522.MIFARE_Read(blockNumber, arrayAddress, &buffersize);
    if (status != MFRC522::STATUS_OK) {
        Serial.println("iBan is niet geldig!");
        return;
    } 

    for (byte index = 0; index < 6; index++) {
        key.keyByte[index] = 0xFF;
    }
  
    String content = "";
    for(int index = 0; index < sizeof(readBackBlock); index++){
        content += char(readBackBlock[index]);
    }
}

void getIban(){
  if(mfrc522.PICC_ReadCardSerial()){
    return;
  }
  if(mfrc522.PICC_IsNewCardPresent()){
    return;
  }
  readBlock();
}


void loop() {
  Key = keypad.getKey();
  if(Key != NULL) { 
      Serial.print(Key);
    } 
  getIban();
}
