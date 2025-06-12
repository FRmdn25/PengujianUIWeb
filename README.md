Pengujian UI Web - Saucedemo

Proyek ini adalah kerangka otomatisasi pengujian UI menggunakan:
- Java
- Gradle
- Selenium WebDriver
- Cucumber
- JUnit
- Page Object Model (POM)

Website yang diuji: (https://www.saucedemo.com)

---

Struktur Proyek

src/
├── main/java/pages → Page Object (LoginPage, InventoryPage)
├── test/java/stepdefinitions → Langkah-langkah pengujian
├── test/java/runners → Cucumber test runner
├── test/resources/features → File Gherkin (*.feature)
