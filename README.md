# **♻️ SmartBin Solutions – Automated Waste Segregation System** 🚀

## **🌍 Overview**
The **SmartBin Solutions** project is an **IoT-based automated waste segregation system** that uses **camera vision** and **machine learning** to classify waste into recyclable, organic, and hazardous categories in real-time. This system enhances waste management efficiency, reduces contamination, and promotes recycling efforts by automating the segregation process.

---

## **✨ Key Features**
- 🔍 **Real-Time Waste Classification:** Uses **camera vision** and **machine learning** to classify waste into recyclable, organic, and hazardous categories.  
- ⚙️ **Automated Waste Disposal:** Integrates **servo motors** and **Arduino Uno** to automatically segregate waste into designated bins.  
- 🌐 **IoT Integration:** Utilizes **ESP8266** for wireless communication and system control.  
- 🖥️ **User-Friendly Interface:** Built with **Flask** to provide a web-based interface for monitoring and control.  
- 🔄 **Efficient Waste Management:** Reduces contamination in recycling processes and improves overall waste management efficiency.  

---

## **🛠 Technologies Used**
- **Hardware:**  
  - 🟢 Arduino Uno  
  - 📡 ESP8266 (Wi-Fi Module)  
  - ⚙️ Servo Motors  
  - 📷 Camera Module  
- **Software:**  
  - 🐍 Python  
  - 🖼️ OpenCV (for image processing and waste detection)  
  - 🤖 TensorFlow/Keras (for machine learning model training)  
  - 🌐 Flask (for web interface)  
- **Tools:**  
  - 📊 Google Colab (for model training)  
  - 🔌 Arduino IDE (for microcontroller programming)  

---

## **⚡ How It Works**
1. 📷 **Waste Detection:** The camera captures an image of the waste, and the **machine learning model** (trained using **TensorFlow/Keras**) classifies it into recyclable, organic, or hazardous categories.  
2. 🏗️ **Segregation:** Based on the classification, the **Arduino Uno** controls **servo motors** to open the corresponding bin for waste disposal.  
3. 📡 **IoT Communication:** The **ESP8266** module enables wireless communication, allowing real-time monitoring and control via a **Flask-based web interface**.  
4. 📢 **User Feedback:** The system provides feedback to users on proper waste disposal methods, promoting sustainable practices.  

---

## **🛠 Installation and Setup**
### **🖥️ Hardware Setup**
1. Connect the **Arduino Uno**, **ESP8266**, **servo motors**, and **camera module** as per the circuit diagram.  
2. Power the system using a suitable power source.  

### **💻 Software Setup**
1. **Install Dependencies:**  
   ```bash
   pip install opencv-python tensorflow flask numpy
   ```

2. **Upload Arduino Code:**  
   - Open the Arduino IDE and upload the provided code to the **Arduino Uno**.  

3. **Run Flask Application:**  
   ```bash
   python app.py
   ```

4. Access the web interface via the provided IP address.  

---

## **📂 Project Structure**
```
SmartBin-Solutions/
├── arduino_code/            # Arduino code for controlling servo motors
├── machine_learning_model/  # Python scripts for waste classification
├── flask_app/               # Flask web interface for monitoring
├── README.md                 # Project documentation
└── requirements.txt         # Python dependencies
```

---

## **🏆 Results**
✅ Achieved **high accuracy** in waste classification using the trained machine learning model.  
✅ Successfully automated waste segregation, reducing manual effort and contamination in recycling processes.  
✅ Enabled real-time monitoring and control through the **Flask-based web interface**.  

---

## **🚀 Future Enhancements**
☀️ Integrate **solar power** for energy efficiency.  
🔊 Add **voice feedback** for user guidance.  
📈 Expand the system to handle more waste categories.  

---
## 🎥 Video Reference
A demonstration video of the project can be accessed through the following link:
[▶️ Project Video](https://www.youtube.com/watch?v=riHRDPI6oL0)
---
## Contributors
- **Prathamesh & Team**

## 📩  Contact
- **GitHub**: [PrathameshNalage](#) (https://github.com/PrathameshNalage)
- **Email**: [prathameshnalage123@gmail.com](prathameshnalage123@gmail.com)
