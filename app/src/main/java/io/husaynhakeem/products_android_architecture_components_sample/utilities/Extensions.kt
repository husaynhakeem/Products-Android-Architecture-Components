/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.utilities

import java.util.*


fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start