# naver-map-compose

[![Download](https://api.bintray.com/packages/namhyun-gu/maven/naver-map-compose/images/download.svg?version=0.1.0) ](https://bintray.com/namhyun-gu/maven/naver-map-compose/0.1.0/link)

## Getting Started

Add dependency codes to your **module** level `build.gradle` file.

```groovy
dependencies {
  implementation "com.github.namhyungu.naver-map-compose:0.1.0"
  implementation "com.naver.maps:map-sdk:3.9.1"
}
```

## Usage

- Use `NaverMapView` composable function.

```kotlin
NaverMapView(
  modifier = Modifier,
  onMapReady = { map ->
    // Initialize NaverMap
  }
)
```

## References

- https://github.com/android/compose-samples/blob/cbede8b51721e546b089c9afffb2792fccd304de/Crane/app/src/main/java/androidx/compose/samples/crane/details/DetailsActivity.kt#L126

- https://github.com/android/compose-samples/blob/34a75fb3672622a3fb0e6a78adc88bbc2886c28f/Crane/app/src/main/java/androidx/compose/samples/crane/details/MapViewUtils.kt

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