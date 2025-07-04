# 📝 Notepad – Java Swing Text Editor

A powerful, customizable, and beginner-friendly **Notepad** built using **Java Swing**. This desktop application replicates and extends classic text editor features like editing, formatting, status bar, themes, fonts, and shortcuts.

---

## 📁 Project Structure

```
Notepad/
    │
    ├── .idea/
    │
    ├── installer/
    │       ├── icon.ico
    │       └── Notepad.jar                         # Executable JAR
    ├── out/
    │     ├── artifacts/
    │     └── production/
    ├── src/
    │     └── com/
    │     │      └── notepad/
    │     │              ├── GUI.java               # Main Application
    │     │              ├── fileFunction.java      # File menu logic
    │     │              ├── editFunction.java      # Edit actions
    │     │              ├── viewFunction.java      # View toggles
    │     │              ├── helpFunction.java      # About dialogs
    │     │              ├── setFunction.java       # Fonts, themes
    │     │              ├── KeyHandler.java        # Keyboard shortcuts
    │     │              ├── developer.png          # Developer image
    │     │              └── notepadIcon.png        # App icon
          └── META-INF/
    │           └── MANIFEST.MF                     # Manifest for JAR
    └── Notepad.iml
```


---

## 🚀 Features

- 🖋️ Fully-functional **Text Editor** (write, open, save, print).
- 🧠 Smart status bar showing live word count & line numbers.
- 🎨 **Themes**: Light, Dark, and Default.
- 🔠 Rich **Font settings**:
  - Font family
  - Font size
  - Style: Regular, Bold, Italic
- 🔁 Undo / Redo, Cut / Copy / Paste
- 🔎 Find, Select All, Date/Time
- 🔍 Zoom In / Out
- ✅ Word Wrap toggle
- 🎯 Keyboard shortcuts for every operation
- 📦 Executable JAR with icon and dependencies

---

## 🎮 Menu System Overview

### 📂 File Menu
- New, New Window
- Open, Save, Save As
- Print
- Exit

### ✏️ Edit Menu
- Undo, Redo, Cut, Copy, Paste
- Find, Select All, Date/Time

### 🧩 View Menu
- Zoom In, Zoom Out
- Restore Default Zoom
- Toggle Status Bar
- Toggle Word Wrap

### ❓ Help Menu
- About Developer
- About Notepad

### ⚙️ Setting Menu
- App Theme (Light, Dark, Default)
- Font Family, Size, Style

---

## 📦 Technologies Used

| Tool                         | Version       | Download Link                                                                 |
|------------------------------|---------------|-------------------------------------------------------------------------------|
| Java (JDK)                   | 1.8.0_212      | [Download Java 1.8.0_212 (Oracle)](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) |
| JavaFX                       | Built-in with JDK 8 | *(No separate install needed)*                                                |
| IntelliJ IDEA Community      | 2017.2.7       | [Download IntelliJ 2017.2.7](https://www.jetbrains.com/idea/download/other.html) |

> **Note:** JavaFX is bundled with JDK 8. No additional modules or SDKs are needed.         |

---

## 💻 How to Run the Project

1. Clone or download the repository.
2. Open in **IntelliJ IDEA** (or any IDE).
3. Set project SDK to Java 8+.
4. Run `GUI.java`.

---

## 🧰 How to Build Executable JAR

1. In IntelliJ IDEA:
   - `File → Project Structure → Artifacts`
   - Click `+` → **JAR → From modules with dependencies**
   - Set Main Class: `com.notepad.GUI`
   - Include:
     - `notepadIcon.png`
     - `MANIFEST.MF`
2. Build → Build Artifacts → `Notepad.jar`

The final JAR file will be located in:
```
out/artifacts/Notepad_jar/Notepad.jar
```


---

## 💬 About Dialogs

### 🔹 Help → About The Text-Editor

> A simple but powerful Notepad clone made entirely in Java. Customize it, learn from it, and build your own tools!

---

## 📥 Download

👉 [Download Notepad.jar](#)  

---

## 🧠 Learning Points

- Java Swing layout and styling
- Event-driven programming
- KeyBinding and ActionListeners
- Separation of logic into helper classes
- Building polished UI and theme switching
- Packaging Java projects with resources

---

## 📄 License

This project is open for **educational and personal use**.

---

## 👨‍💻 Author

**Kanhaiya Gupta**  
📧 [kanhaiyaguptaksg@gmail.com](mailto:kanhaiyaguptaksg@gmail.com)  
🌐 [Visit Portfolio](http://officialkanha.epizy.com/)  
🎓 Java Developer | GUI Enthusiast

---

> _"Type. Build. Customize. Learn."_ 💡💻✍️
