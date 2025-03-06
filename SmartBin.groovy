import os
import cv2
import cvzone
from cvzone.ClassificationModule import Classifier
import serial
import time

# Initialize serial communication with Arduino
ser = serial.Serial('COM3', 9600) # Change 'COM3' to the appropriate port
time.sleep(2) # Allow time for Arduino to initialize
classifier = Classifier('','')# Replace the location
imgArrow = cv2.imread('',# Replace the location
cv2.IMREAD_UNCHANGED)
classIDBin = 0
# Import all the waste images
imgWasteList = []
pathFolderWaste = ''# Replace the location
pathList = os.listdir(pathFolderWaste)
for path in pathList:
imgWasteList.append(cv2.imread(os.path.join(pathFolderWaste, path), cv2.IMREAD_UNCHANGED))
# Import all the waste images
imgBinsList = []
pathFolderBins = ''# Replace the location
pathList = os.listdir(pathFolderBins)
for path in pathList:
imgBinsList.append(cv2.imread(os.path.join(pathFolderBins, path), cv2.IMREAD_UNCHANGED))
# 1 = recyclable
# 2 = organic
# 3 = hazardous
classDic = {0: None,
1: 1,
2: 1,
3: 1,
4: 3,
5: 3,
6: 2,
7: 2}
# Open the camera for 10 seconds
cap = cv2.VideoCapture(0)
start_time = time.time()
object_detected = False
while time.time() - start_time < 10:
ret, img = cap.read()
if not ret:
imgResize = cv2.resize(img, (454, 340))
imgBackground = cv2.imread('')
predection = classifier.getPrediction(img)
classID = predection[1]
print(classID)
if classID != 0:
# imgBackground = cvzone.overlayPNG(imgBackground, imgWasteList[classID - 1], (909, 127))
imgBackground = cvzone.overlayPNG(imgBackground, imgArrow, (978, 320))
classIDBin = classDic[classID]
object_detected = True
imgBackground = cvzone.overlayPNG(imgBackground, imgBinsList[classIDBin], (895, 374))
imgBackground[148:148 + 340, 159:159 + 454] = imgResize
# Display the image
cv2.imshow("Output", imgBackground)
cv2.waitKey(1)
# After the loop ends, send waste type classification to Arduino if an object was detected
if object_detected:
waste_type = str(classIDBin)
ser.write(waste_type.encode())
cap.release()
cv2.destroyAllWindows()
Embedded C Code (Arduino IDE):
#include <Servo.h>
Servo servoRecyclable;
Servo servoHazardous;
Servo servoFood;
int binNumber;
bool binOpened = false; // Flag to track if a bin is currently open
void setup() {
servoRecyclable.attach(9); // Attach servo for recyclable waste to pin 9
servoHazardous.attach(10); // Attach servo for hazardous waste to pin 10
servoFood.attach(11); // Attach servo for food waste to pin 11
Serial.begin(9600); // Initialize serial communication
}
void loop() {
if (Serial.available() > 0) {
binNumber = Serial.parseInt(); // Read bin number from serial
Serial.print("Received bin number: ");
Serial.println(binNumber);
openBin(binNumber);
}
}
void openBin(int binNumber) {
// Close any open bins first before opening a new one
if (binOpened) {
// closeOpenBins();
binOpened = false;
}
if (binNumber == 1) {
Serial.println("Opening hazardous waste bin");
servoHazardous.write(0); // Open hazardous waste bin
delay(5000); // Delay to keep the bin open
servoHazardous.write(90); // Close the bin
binOpened = true;
Serial.println("Hazardous waste bin closed");
} else if (binNumber == 2) {
Serial.println("Opening food waste bin");
servoFood.write(0); // Open food waste bin
delay(5000); // Delay to keep the bin open
servoFood.write(90); // Close the bin
binOpened = true;
Serial.println("Food waste bin closed");
} else if (binNumber == 3) {
Serial.println("Opening recyclable waste bin");
servoRecyclable.write(0); // Open recyclable waste bin
delay(5000); // Delay to keep the bin open
servoRecyclable.write(90); // Close the bin
binOpened = true;
Serial.println("Recyclable waste bin closed");
}
}
