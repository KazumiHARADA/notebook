package jp.co.proc.notebook.presentation.di

/**
 * Interface representing a contract for clients that contains a fragmentComponent for dependency injection.
 */
interface HasComponent<C> {
    val fragmentComponent: C?
}
