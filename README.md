# Dinosaur Atlas – Android App

A simple, lightweight Android application written in Kotlin using Jetpack Compose that serves as a dinosaur atlas. It loads dinosaur data dynamically from a JSON file (online or cached) and displays detailed information for each dinosaur.  

---

## Table of Contents

- [Features](#features)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [JSON Data](#json-data)
- [Dependencies](#dependencies)
- [Notes](#notes)

---

## Features

- Display a list of dinosaurs with thumbnails and names.
- Click on a dinosaur to see detailed information:
  - Common and scientific name
  - Era, period, diet, weight, length, height, and speed
  - Scaled image of the dinosaur
- Interactive buttons to show more detailed information about:
  - **Classification**
  - **Characteristics**
  - **Habitat**
- Dark theme support for a modern look.
- Offline support using cached JSON data.
- Smooth loading animation while fetching data.

---

## Screenshots

<p align="center">
  <b>Main Screen – Dinosaur List</b><br>
  <img src="https://github.com/user-attachments/assets/1905f7d8-ec78-45c2-bb18-29e26248697b" width="400">
</p>

<p align="center">
  <b>Details Screen – Dinosaur Information</b><br>
  <img src="https://github.com/user-attachments/assets/21b0fc3f-786a-4b57-9036-887b5b6a4295" width="400">
</p>

<p align="center">
  <b>More Info Modal – Classification, Characteristics, Habitat</b><br>
  <img src="https://github.com/user-attachments/assets/972d34ba-a2b4-440d-9e3f-f47d0a9ac606" width="400">
</p>


---

## Installation

1. Clone the repository:  

```bash
git clone https://github.com/shrowd/dino_atlas.git
```

2. Open the project in Android Studio.

3. Build the project and run on an emulator or a physical device (minSdk 24 / Android 7).

4. Alternatively, you can install the app-debug.apk directly on your device.

---

## JSON Data

The app loads a JSON file containing dinosaur data, including:

- `id`, `name`, `scientificName`, `era`, `diet`, `weightTons`, `lengthMeters`, `heightMeters`, `speedKmh`
- Nested objects: `classification`, `characteristics`, `habitat`
- `imageUrl` for online images

Cached locally to allow offline usage.

---

## Dependencies

- Kotlin, Jetpack Compose, Material3
- OkHttp3 – for downloading JSON
- Gson – for parsing JSON
- Coil – for loading images
- AndroidX Navigation Compose

---

## Notes

- Works best on Android 7+ (API 24+)
- Dark theme enabled by default in the app
- The JSON source can be updated via GitHub raw URL for testing new dinosaurs
