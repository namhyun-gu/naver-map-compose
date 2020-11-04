# naver-map-compose

[![Download](https://api.bintray.com/packages/namhyun-gu/intentcontract/intentcontract-compiler/images/download.svg)](https://bintray.com/namhyun-gu/intentcontract/intentcontract-compiler/_latestVersion)
![Publish](https://github.com/namhyun-gu/intent-contract/workflows/Publish/badge.svg)
![GitHub](https://img.shields.io/github/license/namhyun-gu/intent-contract)

## Getting Started

Add dependency codes to your **module** level `build.gradle` file.

```groovy
dependencies {
  implementation "com.github.namhyungu.navermapcompose:0.1.0"
  implementation "com.naver.maps:map-sdk:3.9.1"
}
```

## Usage

- Add `NaverMapView` composable function.

```kotlin
NaverMapView(
  modifier = Modifier,
  onMapReady = { map ->
    // Initialize NaverMap
  }
)
```

## License

```xml
Copyright 2020 Namhyun, Gu

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```