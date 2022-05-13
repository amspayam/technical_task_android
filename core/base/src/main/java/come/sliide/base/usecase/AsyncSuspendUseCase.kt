package come.sliide.base.usecase

interface AsyncSuspendUseCase<RQ, RS> {
    suspend fun executeAsync(rq: RQ): RS
}