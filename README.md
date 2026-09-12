# React Native & Android Communication Demo (2026 Modernized)

> **Development home:** https://github.com/ImL1s/reactNative-androidCommunication  
> Please open issues and pull requests there.  
> **Mirrors:** [Codeberg](https://codeberg.org/ImL1s/reactNative-androidCommunication) · [GitLab](https://gitlab.com/aa22396584/reactNative-androidCommunication)


[![React Native](https://img.shields.io/badge/React_Native-0.84.0-61DAFB?logo=react&logoColor=black)](https://reactnative.dev/)
[![Android](https://img.shields.io/badge/Android-15_(SDK_35)-3DDC84?logo=android&logoColor=white)](https://developer.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.3.0-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![License: ISC](https://img.shields.io/badge/License-ISC-blue.svg)](https://opensource.org/licenses/ISC)

這是一個 **2026年現代化** 的示範專案，展示如何讓 **React Native (0.84+)** 與 **Android (Kotlin 2.3+)** 進行高效的雙向通訊。本版本特別強化了 **視覺美學** 與 **代碼健壯性**。

---

## ✨ 2026 現代化更新亮點

- **最新技術棧**：React Native 0.84, React 19, Android 15 (SDK 35)。
- **AndroidX & Kotlin 2.3**：全面遷移至 AndroidX 並使用最新的 Kotlin 編譯器。
- **Functional Components & Hooks**：JS 端採用 `useState` 與 `useEffect`。
- **視覺美化**：
    - **Android**: 使用 Material CardView, ConstraintLayout 與 HSL 色彩系統。
    - **React Native**: 實現了陰影 (Shadows)、圓角與類玻璃擬態 (Glassmorphism) 效果。

---

## 🏗️ 系統架構

```mermaid
graph TD
    subgraph "React Native (JS/TS Side)"
        JS[React Components] --> Hooks[Hooks / useState]
        Hooks --> RN_Modules[NativeModules / DeviceEventEmitter]
    end

    subgraph "Bridge (JSI / Legacy Bridge)"
        RN_Modules <--> |"Synchronous / Asynchronous"| Bridge_Logic[JSON / JSI Communication]
    end

    subgraph "Android (Native Side)"
        Bridge_Logic <--- "Native Interface" ---> KT_Module[Kotlin Native Module]
        KT_Module <--- "Event / Call" ---> Android_OS[Android System / UI]
    end

    style JS fill:#61DAFB,stroke:#333
    style KT_Module fill:#7F52FF,stroke:#333,color:#fff
    style Bridge_Logic fill:#f9f,stroke:#333
```

---

## 📂 專案結構

```text
.
├── app
│   ├── js                     # React Native JS 原始碼 (Hooks + Styled)
│   │   ├── index.js           # 進入點與組件註冊
│   │   └── communication1-3.js # 功能組件示範
│   ├── src/main/java          # Android Kotlin 原始碼 (AndroidX)
│   │   └── com/.../hybrid
│   │       ├── MainActivity.kt           # 入口 Activity (Modern UI)
│   │       ├── ReactCommunicationActivity.kt # 通訊範例 Activity
│   │       └── other/                    # Native Modules
│   └── build.gradle           # App 級與 SDK 配置
├── package.json               # NPM 依賴與現代化 Scripts
└── README.md                  # 說明文件
```

---

## 🛠️ 快速開始

### 1. 環境準備
- [Node.js](https://nodejs.org/) (LTS)
- [Android Studio](https://developer.android.com/studio) (Koala+)
- JDK 17+

### 2. 安裝與運行
```bash
npm install
npm start          # 啟動 Metro Bundler
npm run android    # 運行 Android App
```

---

## 📡 通訊機制深入探討

### 1. React Native 呼叫 Android (Native Modules)
當 JS 端調用 `NativeModules` 時，React Native 會通過 **JSI (JavaScript Interface)** 直接映射到原生端的 Kotlin 方法，這比舊版的非同步 Bridge 更快。

```javascript
import { NativeModules } from 'react-native';
const { ToastAndroidModule } = NativeModules;

// 在組件中調用
ToastAndroidModule.HandleMessage("Hello from RN!");
```

### 2. Android 主動發送事件 (DeviceEventEmitter)
Android 端發送事件，JS 端使用 `useEffect` 進行監聽，這在處理硬件傳感器數據時非常有用。

```javascript
useEffect(() => {
  const sub = DeviceEventEmitter.addListener('mEventName', (data) => {
    setInfo(data);
  });
  return () => sub.remove(); // 清理資源
}, []);
```

---

## �️ 最佳實踐與 FAQ

- **記憶體管理**：務必在 `useEffect` 的 Cleanup function 中移除監聽器。
- **UI 響應**：原生按鈕與 RN 視圖的權重分配已在 XML 中優化，避免在大屏幕上比例失調。
- **調試工具**：推薦使用 **Flipper** 進行 Bridge 流量監控。

---

## 👤 作者
- **ImL1s** - [iml1s@outlook.com](mailto:iml1s@outlook.com)
- **GitHub**: [ImL1s](https://github.com/ImL1s)

---

## Support / 支持

If this project saved you some time, you can [buy me a coffee](https://buymeacoffee.com/iml1s).

如果這個專案幫你省了點時間，可以請我喝杯咖啡。
