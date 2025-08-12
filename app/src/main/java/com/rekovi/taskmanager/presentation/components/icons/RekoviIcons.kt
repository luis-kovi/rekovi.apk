package com.rekovi.taskmanager.presentation.components.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

// Ícones customizados da Rekovi em SVG
object RekoviIcons {
    
    val Car: ImageVector
        get() {
            if (_car != null) {
                return _car!!
            }
            _car = materialIcon(name = "Car") {
                materialPath {
                    moveTo(18.92f, 6.01f)
                    curveTo(18.72f, 5.42f, 18.16f, 5.0f, 17.5f, 5.0f)
                    horizontalLineTo(6.5f)
                    curveTo(5.84f, 5.0f, 5.28f, 5.42f, 5.08f, 6.01f)
                    lineTo(3.0f, 12.0f)
                    verticalLineTo(20.0f)
                    curveTo(3.0f, 20.55f, 3.45f, 21.0f, 4.0f, 21.0f)
                    horizontalLineTo(5.0f)
                    curveTo(5.55f, 21.0f, 6.0f, 20.55f, 6.0f, 20.0f)
                    verticalLineTo(19.0f)
                    horizontalLineTo(18.0f)
                    verticalLineTo(20.0f)
                    curveTo(18.0f, 20.55f, 18.45f, 21.0f, 19.0f, 21.0f)
                    horizontalLineTo(20.0f)
                    curveTo(20.55f, 21.0f, 21.0f, 20.55f, 21.0f, 20.0f)
                    verticalLineTo(12.0f)
                    lineTo(18.92f, 6.01f)
                    close()
                    moveTo(6.5f, 16.0f)
                    curveTo(5.67f, 16.0f, 5.0f, 15.33f, 5.0f, 14.5f)
                    reflectiveCurveTo(5.67f, 13.0f, 6.5f, 13.0f)
                    reflectiveCurveTo(8.0f, 13.67f, 8.0f, 14.5f)
                    reflectiveCurveTo(7.33f, 16.0f, 6.5f, 16.0f)
                    close()
                    moveTo(17.5f, 16.0f)
                    curveTo(16.67f, 16.0f, 16.0f, 15.33f, 16.0f, 14.5f)
                    reflectiveCurveTo(16.67f, 13.0f, 17.5f, 13.0f)
                    reflectiveCurveTo(19.0f, 13.67f, 19.0f, 14.5f)
                    reflectiveCurveTo(18.33f, 16.0f, 17.5f, 16.0f)
                    close()
                    moveTo(5.0f, 11.0f)
                    lineTo(6.5f, 7.0f)
                    horizontalLineTo(17.5f)
                    lineTo(19.0f, 11.0f)
                    horizontalLineTo(5.0f)
                    close()
                }
            }
            return _car!!
        }
    private var _car: ImageVector? = null

    val Location: ImageVector
        get() {
            if (_location != null) {
                return _location!!
            }
            _location = materialIcon(name = "Location") {
                materialPath {
                    moveTo(12.0f, 2.0f)
                    curveTo(8.13f, 2.0f, 5.0f, 5.13f, 5.0f, 9.0f)
                    curveTo(5.0f, 14.25f, 12.0f, 22.0f, 12.0f, 22.0f)
                    reflectiveCurveTo(19.0f, 14.25f, 19.0f, 9.0f)
                    curveTo(19.0f, 5.13f, 15.87f, 2.0f, 12.0f, 2.0f)
                    close()
                    moveTo(12.0f, 11.5f)
                    curveTo(10.62f, 11.5f, 9.5f, 10.38f, 9.5f, 9.0f)
                    reflectiveCurveTo(10.62f, 6.5f, 12.0f, 6.5f)
                    reflectiveCurveTo(14.5f, 7.62f, 14.5f, 9.0f)
                    reflectiveCurveTo(13.38f, 11.5f, 12.0f, 11.5f)
                    close()
                }
            }
            return _location!!
        }
    private var _location: ImageVector? = null

    val Phone: ImageVector
        get() {
            if (_phone != null) {
                return _phone!!
            }
            _phone = materialIcon(name = "Phone") {
                materialPath {
                    moveTo(6.62f, 10.79f)
                    curveTo(8.06f, 13.62f, 10.38f, 15.94f, 13.21f, 17.38f)
                    lineTo(15.41f, 15.18f)
                    curveTo(15.69f, 14.9f, 16.08f, 14.82f, 16.43f, 14.93f)
                    curveTo(17.55f, 15.3f, 18.75f, 15.5f, 20.0f, 15.5f)
                    curveTo(20.55f, 15.5f, 21.0f, 15.95f, 21.0f, 16.5f)
                    verticalLineTo(20.0f)
                    curveTo(21.0f, 20.55f, 20.55f, 21.0f, 20.0f, 21.0f)
                    curveTo(10.61f, 21.0f, 3.0f, 13.39f, 3.0f, 4.0f)
                    curveTo(3.0f, 3.45f, 3.45f, 3.0f, 4.0f, 3.0f)
                    horizontalLineTo(7.5f)
                    curveTo(8.05f, 3.0f, 8.5f, 3.45f, 8.5f, 4.0f)
                    curveTo(8.5f, 5.25f, 8.7f, 6.45f, 9.07f, 7.57f)
                    curveTo(9.18f, 7.92f, 9.1f, 8.31f, 8.82f, 8.59f)
                    lineTo(6.62f, 10.79f)
                    close()
                }
            }
            return _phone!!
        }
    private var _phone: ImageVector? = null

    val User: ImageVector
        get() {
            if (_user != null) {
                return _user!!
            }
            _user = materialIcon(name = "User") {
                materialPath {
                    moveTo(12.0f, 12.0f)
                    curveTo(14.21f, 12.0f, 16.0f, 10.21f, 16.0f, 8.0f)
                    reflectiveCurveTo(14.21f, 4.0f, 12.0f, 4.0f)
                    reflectiveCurveTo(8.0f, 5.79f, 8.0f, 8.0f)
                    reflectiveCurveTo(9.79f, 12.0f, 12.0f, 12.0f)
                    close()
                    moveTo(12.0f, 14.0f)
                    curveTo(9.33f, 14.0f, 4.0f, 15.34f, 4.0f, 18.0f)
                    verticalLineTo(20.0f)
                    horizontalLineTo(20.0f)
                    verticalLineTo(18.0f)
                    curveTo(20.0f, 15.34f, 14.67f, 14.0f, 12.0f, 14.0f)
                    close()
                }
            }
            return _user!!
        }
    private var _user: ImageVector? = null

    val Building: ImageVector
        get() {
            if (_building != null) {
                return _building!!
            }
            _building = materialIcon(name = "Building") {
                materialPath {
                    moveTo(12.0f, 2.0f)
                    lineTo(2.0f, 7.0f)
                    lineTo(2.0f, 17.0f)
                    horizontalLineTo(6.0f)
                    verticalLineTo(15.0f)
                    horizontalLineTo(8.0f)
                    verticalLineTo(17.0f)
                    horizontalLineTo(10.0f)
                    verticalLineTo(15.0f)
                    horizontalLineTo(12.0f)
                    verticalLineTo(17.0f)
                    horizontalLineTo(14.0f)
                    verticalLineTo(15.0f)
                    horizontalLineTo(16.0f)
                    verticalLineTo(17.0f)
                    horizontalLineTo(18.0f)
                    verticalLineTo(15.0f)
                    horizontalLineTo(20.0f)
                    verticalLineTo(17.0f)
                    horizontalLineTo(22.0f)
                    verticalLineTo(7.0f)
                    lineTo(12.0f, 2.0f)
                    close()
                    moveTo(12.0f, 4.14f)
                    lineTo(19.0f, 8.0f)
                    verticalLineTo(13.0f)
                    horizontalLineTo(17.0f)
                    verticalLineTo(11.0f)
                    horizontalLineTo(15.0f)
                    verticalLineTo(13.0f)
                    horizontalLineTo(13.0f)
                    verticalLineTo(11.0f)
                    horizontalLineTo(11.0f)
                    verticalLineTo(13.0f)
                    horizontalLineTo(9.0f)
                    verticalLineTo(11.0f)
                    horizontalLineTo(7.0f)
                    verticalLineTo(13.0f)
                    horizontalLineTo(5.0f)
                    verticalLineTo(8.0f)
                    lineTo(12.0f, 4.14f)
                    close()
                }
            }
            return _building!!
        }
    private var _building: ImageVector? = null

    val Truck: ImageVector
        get() {
            if (_truck != null) {
                return _truck!!
            }
            _truck = materialIcon(name = "Truck") {
                materialPath {
                    moveTo(20.0f, 8.0f)
                    horizontalLineTo(17.0f)
                    verticalLineTo(4.0f)
                    horizontalLineTo(3.0f)
                    curveTo(1.9f, 4.0f, 1.0f, 4.9f, 1.0f, 6.0f)
                    verticalLineTo(17.0f)
                    horizontalLineTo(3.0f)
                    curveTo(3.0f, 18.66f, 4.34f, 20.0f, 6.0f, 20.0f)
                    reflectiveCurveTo(9.0f, 18.66f, 9.0f, 17.0f)
                    horizontalLineTo(15.0f)
                    curveTo(15.0f, 18.66f, 16.34f, 20.0f, 18.0f, 20.0f)
                    reflectiveCurveTo(21.0f, 18.66f, 21.0f, 17.0f)
                    horizontalLineTo(23.0f)
                    verticalLineTo(13.0f)
                    curveTo(23.0f, 10.79f, 21.21f, 9.0f, 20.0f, 8.0f)
                    close()
                    moveTo(6.0f, 18.5f)
                    curveTo(5.17f, 18.5f, 4.5f, 17.83f, 4.5f, 17.0f)
                    reflectiveCurveTo(5.17f, 15.5f, 6.0f, 15.5f)
                    reflectiveCurveTo(7.5f, 16.17f, 7.5f, 17.0f)
                    reflectiveCurveTo(6.83f, 18.5f, 6.0f, 18.5f)
                    close()
                    moveTo(18.0f, 18.5f)
                    curveTo(17.17f, 18.5f, 16.5f, 17.83f, 16.5f, 17.0f)
                    reflectiveCurveTo(17.17f, 15.5f, 18.0f, 15.5f)
                    reflectiveCurveTo(19.5f, 16.17f, 19.5f, 17.0f)
                    reflectiveCurveTo(18.83f, 18.5f, 18.0f, 18.5f)
                    close()
                    moveTo(17.0f, 12.0f)
                    verticalLineTo(9.5f)
                    horizontalLineTo(19.5f)
                    lineTo(21.46f, 12.0f)
                    horizontalLineTo(17.0f)
                    close()
                }
            }
            return _truck!!
        }
    private var _truck: ImageVector? = null

    val ExternalLink: ImageVector
        get() {
            if (_externalLink != null) {
                return _externalLink!!
            }
            _externalLink = materialIcon(name = "ExternalLink") {
                materialPath {
                    moveTo(14.0f, 3.0f)
                    verticalLineTo(5.0f)
                    horizontalLineTo(17.59f)
                    lineTo(7.76f, 14.83f)
                    lineTo(9.17f, 16.24f)
                    lineTo(19.0f, 6.41f)
                    verticalLineTo(10.0f)
                    horizontalLineTo(21.0f)
                    verticalLineTo(3.0f)
                    horizontalLineTo(14.0f)
                    close()
                    moveTo(19.0f, 19.0f)
                    horizontalLineTo(5.0f)
                    verticalLineTo(5.0f)
                    horizontalLineTo(12.0f)
                    verticalLineTo(3.0f)
                    horizontalLineTo(5.0f)
                    curveTo(3.89f, 3.0f, 3.0f, 3.9f, 3.0f, 5.0f)
                    verticalLineTo(19.0f)
                    curveTo(3.0f, 20.1f, 3.89f, 21.0f, 5.0f, 21.0f)
                    horizontalLineTo(19.0f)
                    curveTo(20.1f, 21.0f, 21.0f, 20.1f, 21.0f, 19.0f)
                    verticalLineTo(12.0f)
                    horizontalLineTo(19.0f)
                    verticalLineTo(19.0f)
                    close()
                }
            }
            return _externalLink!!
        }
    private var _externalLink: ImageVector? = null

    val ArrowBack: ImageVector
        get() {
            if (_arrowBack != null) {
                return _arrowBack!!
            }
            _arrowBack = materialIcon(name = "ArrowBack") {
                materialPath {
                    moveTo(20.0f, 11.0f)
                    horizontalLineTo(7.83f)
                    lineTo(13.42f, 5.41f)
                    lineTo(12.0f, 4.0f)
                    lineTo(4.0f, 12.0f)
                    lineTo(12.0f, 20.0f)
                    lineTo(13.41f, 18.59f)
                    lineTo(7.83f, 13.0f)
                    horizontalLineTo(20.0f)
                    verticalLineTo(11.0f)
                    close()
                }
            }
            return _arrowBack!!
        }
    private var _arrowBack: ImageVector? = null

    val Info: ImageVector
        get() {
            if (_info != null) {
                return _info!!
            }
            _info = materialIcon(name = "Info") {
                materialPath {
                    moveTo(12.0f, 2.0f)
                    curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f)
                    reflectiveCurveTo(6.48f, 22.0f, 12.0f, 22.0f)
                    reflectiveCurveTo(22.0f, 17.52f, 22.0f, 12.0f)
                    reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f)
                    close()
                    moveTo(13.0f, 17.0f)
                    horizontalLineTo(11.0f)
                    verticalLineTo(11.0f)
                    horizontalLineTo(13.0f)
                    verticalLineTo(17.0f)
                    close()
                    moveTo(13.0f, 9.0f)
                    horizontalLineTo(11.0f)
                    verticalLineTo(7.0f)
                    horizontalLineTo(13.0f)
                    verticalLineTo(9.0f)
                    close()
                }
            }
            return _info!!
        }
    private var _info: ImageVector? = null

    val Actions: ImageVector
        get() {
            if (_actions != null) {
                return _actions!!
            }
            _actions = materialIcon(name = "Actions") {
                materialPath {
                    moveTo(12.0f, 2.0f)
                    lineTo(13.09f, 8.26f)
                    lineTo(22.0f, 9.0f)
                    lineTo(17.0f, 14.74f)
                    lineTo(19.18f, 22.0f)
                    lineTo(12.0f, 18.77f)
                    lineTo(4.82f, 22.0f)
                    lineTo(7.0f, 14.74f)
                    lineTo(2.0f, 9.0f)
                    lineTo(10.91f, 8.26f)
                    lineTo(12.0f, 2.0f)
                    close()
                }
            }
            return _actions!!
        }
    private var _actions: ImageVector? = null
}
