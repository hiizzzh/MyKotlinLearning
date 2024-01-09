package com.example.littlelemon

import android.media.MediaRouter2.RouteCallback

interface Destination {
    val route: String
    val icon: Int
    val title: String
}

object Home:Destination{
    override val route: String = "Home"
    override val icon = R.drawable.ic_home
    override val title: String = "Home"
}
object Location:Destination{
    override val route: String = "Location"
    override val icon = R.drawable.ic_location
    override val title: String = "Location"
}
object Menu:Destination{
    override val route: String = "Menu"
    override val icon = R.drawable.ic_menu
    override val title: String = "Menu"
}