
# 💣 Mines Predictor – Stake.com Game (Java Console App)

This project is a **predictor tool** for the game **Mines** on [stake.ceo](https://stake.ceo), built using Java as a console-based application. It attempts to simulate the outcome generation logic using the game's fairness mechanism: **Client Seed**, **Server Seed**, and **Nonce**.

> ⚠️ This project is for **educational and research purposes only**. It does not guarantee correct predictions or outcomes on real platforms.

---

## 🔧 Features

- Predicts mine locations based on:
  - Client Seed
  - Server Seed (unhashed)
  - Nonce (bet count)
- Hashing and HMAC logic implemented as per provably fair principles
- Fully written in Java (console-based)
- Easy to run and modify

---

## 🧠 How It Works

Mines game uses a **provably fair algorithm** that combines:
- A **Server Seed** (kept secret and hashed)
- A **Client Seed** (visible to user)
- A **Nonce** (increments with each bet)

These are combined to create a deterministic result using SHA-256 or HMAC. This project mimics that logic to **recreate/predict** mine positions.

---

## ⚙️ Requirements

- Java 8 or above
- Basic understanding of Java console apps
- IDE (like IntelliJ, VSCode, or Eclipse) or command line (javac/java)

---

## 📁 Project Structure


---

## 🛠️ How to Run

1. **Clone or download** this repository.
2. Open in any Java IDE or terminal.
3. Compile and run:
   ```bash
   javac Main.java
   java Main

#### Input:
 **Client Seed:** f52249ce54f82f94  
 **Server Seed (Unhashed):** a191f3850c007f375b71856e3099afa4b9254bb42b7e8991d03951a9b40e7f43  
 **Nonce:** 3

4. **Input the following:**

- Active Client Seed

- Unhashed Server Seed

- Nonce (e.g., 3)

5. View predicted mine locations.




