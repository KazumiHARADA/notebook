package jp.co.proc.notebook.domain.interactor

import io.reactivex.Single
import jp.co.proc.notebook.domain.dto.Word
import jp.co.proc.notebook.domain.executor.PostExecutionThread
import jp.co.proc.notebook.domain.executor.ThreadExecutor
import jp.co.proc.notebook.domain.repository.DicRepository
import javax.inject.Inject

/**
 * Created by kharada on 2019-05-02.
 */
class GetAllWordsUseCase @Inject
internal constructor(
    private val dicRepository: DicRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<List<Word>, Void?>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseSingle(params: Void?): Single<List<Word>> {
        return dicRepository.allSuggestWords()
    }
}