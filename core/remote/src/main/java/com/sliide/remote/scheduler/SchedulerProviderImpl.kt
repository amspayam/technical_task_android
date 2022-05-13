package com.sliide.remote.scheduler

import kotlinx.coroutines.Dispatchers

class SchedulerProviderImpl : SchedulerProvider {
    override fun io() = Dispatchers.IO
    override fun ui() = Dispatchers.Main
    override fun default() = Dispatchers.Default
}
