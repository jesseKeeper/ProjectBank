#include "Adafruit_Thermal.h"
#include "SoftwareSerial.h"
#include <CheapStepper.h>

#define TX_PIN 10 // transmit
#define RX_PIN 11 //receive

SoftwareSerial mySerial(RX_PIN, TX_PIN);
Adafruit_Thermal printer(&mySerial);

CheapStepper stepper50 (2, 3, 4, 5);
CheapStepper stepper20 (6, 7, 8, 9);
CheapStepper stepper10 (22, 23, 24, 25);
CheapStepper stepper5 (26, 27, 28, 29);

String datum;
String tijd;
String rekeningnr;
String s;
int bedrag;
int pinbedrag;
boolean moveClockwise = true;

void setup() {
  bedrag = 1;
  Serial.begin(9600);
  while (!Serial) {
    ;
  }
}

void loop() {
  if (Serial.available() > 0) {
    byte incomingByte = 0;
    //incomingByte = Serial.read(); // read the incoming byte:
    datum = Serial.readStringUntil('&');
    tijd = Serial.readStringUntil('&');
    rekeningnr = Serial.readStringUntil('&');
    s = Serial.readStringUntil('&');
    bedrag = s.toInt();
    pinbedrag = bedrag;
  }

  if (bedrag != 0) {
    if (bedrag >= 50) {
      pin50();
    }

    if (bedrag < 50 && bedrag >= 20) {
      pin20();
    }

    if (bedrag < 20 && bedrag >= 10) {
      pin10();
    }

    if (bedrag < 10 && bedrag >= 5) {
      pin5();
    }

    if (bedrag == 0) {
      printBon();
    }
  }
}


void printBon() {
  mySerial.begin(9600);  // Initialize SoftwareSerial
  printer.begin();        // Init printer (same regardless of serial type)
  printer.boldOn();
  printer.justify('C');
  printer.setSize('L');
  printer.println("Stonks Benc Inc.");
  printer.boldOff();
  printer.write(10);
  printer.justify('L');
  printer.setSize('S');
  printer.println("Automaatnummer: 0001");
  printer.print("Rekeningnummer:");
  printer.print("###########");
  printer.println(rekeningnr);
  printer.print("Bedrag: ");
  printer.print(pinbedrag);
  printer.println(",00 EUR");
  printer.print("Datum: ");
  printer.println(datum);
  printer.print("Tijd: ");
  printer.println(tijd);
  printer.justify('C');
  printer.write(10);
  printer.boldOn();
  printer.println("BEDANKT VOOR UW BEZOEK,");
  printer.println("GRAAG TOT ZIENS.");
  printer.boldOff();
  printer.write(10);
  printer.write(10);
  printer.write(10);
  printer.write(10);
  Serial.println("klaar");
}

void pin50() {
  Serial.println(bedrag);
  moveClockwise = true;
  stepper50.moveTo(moveClockwise, 2048);
  stepper50.moveTo(moveClockwise, 4096);
  bedrag -= 50;
  delay(50);
}

void pin20() {
  Serial.println(bedrag);
  moveClockwise = true;
  stepper20.moveTo(moveClockwise, 2048);
  stepper20.moveTo(moveClockwise, 4096);
  bedrag -= 20;
  delay(50);
}

void pin10() {
  Serial.println(bedrag);
  moveClockwise = true;
  stepper10.moveTo(moveClockwise, 2048);
  stepper10.moveTo(moveClockwise, 4096);
  bedrag -= 10;
  delay(50);
}

void pin5() {
  Serial.println(bedrag);
  moveClockwise = true;
  stepper5.moveTo(moveClockwise, 2048);
  stepper5.moveTo(moveClockwise, 4096);
  bedrag -= 5;
  delay(50);
}
