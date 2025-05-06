package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.navigation

import androidx.navigation.NamedNavArgument

interface NavDestination {
    val route: String
    val argument: List<NamedNavArgument>
}

abstract class NavNoArg : NavDestination {
    override val argument: List<NamedNavArgument> = emptyList()
}

