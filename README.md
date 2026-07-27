# 🤖 SmartButler

An AI-powered personal finance assistant built with **Java**, **Spring Boot**, **MySQL**, and **Large Language Models (LLMs)**.

Unlike traditional finance applications, SmartButler allows users to interact naturally. Instead of filling forms or memorizing commands, users can simply chat with the assistant.

For example:

> **"I spent €15 at McDonald's yesterday."**

SmartButler understands the request, extracts the relevant financial information, categorizes the transaction, stores it in a relational database, and can answer questions about your finances through natural conversation.

---

## ✨ Features

- 💬 Natural language transaction processing
- 💰 Expense and income tracking
- 🏷️ Automatic transaction categorization
- 📊 Financial reports and spending analysis
- 🤖 AI-powered transaction extraction
- 🗄️ MySQL relational database
- 🖥️ Interactive CLI
- 🔄 Multiple AI provider support (Ollama & Gemini)

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Ollama (Llama 3.2)
- Google Gemini (optional)

---

## 📂 Architecture

```text
                 User
                  │
                  ▼
        Interactive CLI / REST API
                  │
                  ▼
            Spring Boot
                  │
                  ▼
             AI Service
      (Ollama or Gemini)
                  │
                  ▼
          Business Logic
                  │
                  ▼
          Spring Data JPA
                  │
                  ▼
               MySQL
```

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/smartbutler.git
cd smartbutler
```

---

### 2. Configure the environment

Copy the example configuration file:

```bash
cp .env.example .env
```

Then update the values according to your local setup.

**Note:** If you plan to use **Ollama**, you don't need to provide a Gemini API key.
If you prefer using **Google Gemini**, simply add your API key to `API_KEY_GEMINI`.

### 3. Start MySQL

Make sure your MySQL server is running.

---

### 4. Start Ollama (Optional)

If you're using Ollama, start the server and ensure the configured model is available.

Example:

```bash
ollama serve
```

---

### 5. Run the Spring Boot application

```bash
mvn spring-boot:run
```

---

### 6. Launch the CLI

Run:

```text
SmartButlerCLI.java
```

The CLI will automatically connect to the running Spring Boot application.


## 💬 Example Conversations

Instead of using fixed commands, users can interact naturally.

Examples:

```
I spent €12 at Lidl
```

```
Paid €40 for fuel yesterday
```

```
Received my monthly salary
```

```
Can you show all my transactions?
```

```
Show my balance
```

```
How much did I spend this month?
```

```
What are my biggest expenses?
```

---

## 📷 Demo

### CLI

![SmartButler CLI](images/cli-demo.png)

---