package co.joebirch.domain.interactor.bookmark

import co.joebirch.domain.executor.PostExecutionThread
import co.joebirch.domain.interactor.ObservableUseCase
import co.joebirch.domain.model.Project
import co.joebirch.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBookmarkedProjects @Inject constructor(
        private val projectsRepository: ProjectsRepository,
        postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Project>, Nothing>(postExecutionThread) {

    public override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }

}