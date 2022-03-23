# Install dependencies

* Node >= 10.16.0
* Latest release of ClojureScript
* Java SDK 8+
* Follow [React Native](https://reactnative.dev/docs/getting-started) document to install Android and iOS SDKs

# Steps to run the application

Install npm packages
```
npm i
```

Run Android app
```
npx shadow-cljs watch android
npm run android
```

Run iOS app
```
npx shadow-cljs watch ios
cd ios && pod install
npm run ios
```

Build and watch tailwind compilation
```
npm run dev:tailwind
```