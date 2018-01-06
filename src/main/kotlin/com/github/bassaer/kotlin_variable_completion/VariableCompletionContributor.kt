package main.kotlin.com.github.bassaer.kotlin_variable_completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement

/**
 * Autocompletion for variable with kotlin
 * Created by nakayama on 2018/01/05.
 */
class VariableCompletionContributor : CompletionContributor() {
    init {
        extend(
                CompletionType.BASIC,
                PlatformPatterns.psiElement(PsiElement::class.java),
                VariableCompletionProvider()
        )
    }
}