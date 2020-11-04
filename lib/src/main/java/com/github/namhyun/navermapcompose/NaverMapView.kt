/*
 * Copyright 2020 Namhyun, Gu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.namhyun.navermapcompose

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.onCommit
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.LifecycleOwnerAmbient
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap

/**
 * NaverMapView is contain [MapView] with AndroidView
 *
 * [modifier]
 * [onMapReady]
 *
 * Reference: https://github.com/android/compose-samples/blob/cbede8b51721e546b089c9afffb2792fccd304de/Crane/app/src/main/java/androidx/compose/samples/crane/details/DetailsActivity.kt#L126
 */
@Composable
fun NaverMapView(
    modifier: Modifier = Modifier,
    onMapReady: (map: NaverMap) -> Unit
) {
    val map = rememberMapViewWithLifecycle()
    AndroidView({ map }, modifier = modifier) { mapView ->
        mapView.getMapAsync(onMapReady)
    }
}

/**
 * Remember created [MapView] and [LifecycleEventObserver]
 *
 * Reference: https://github.com/android/compose-samples/blob/34a75fb3672622a3fb0e6a78adc88bbc2886c28f/Crane/app/src/main/java/androidx/compose/samples/crane/details/MapViewUtils.kt
 *
 * @return [MapView]
 */
@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = ContextAmbient.current
    val mapView = remember {
        MapView(context)
    }

    val lifecycleObserver = rememberMapLifecycleObserver(mapView)
    val lifecycle = LifecycleOwnerAmbient.current.lifecycle

    onCommit(lifecycle) {
        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
        }
    }
    return mapView
}

/**
 * Remember [LifecycleEventObserver]
 *
 * @return [LifecycleEventObserver]
 */
@Composable
fun rememberMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
    remember(mapView) {
        LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                else -> throw IllegalStateException()
            }
        }
    }
