package main.kotlin.com.github.bassaer.kotlin_variable_completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

/**
 * Autocompletion for variable with kotlin
 * Created by nakayama on 2018/01/05.
 */
class VariableCompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC,
            PlatformPatterns.psiElement(PsiElement::class.java),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(completionParameters: CompletionParameters,
                                            processingContext: ProcessingContext?,
                                            completionResultSet: CompletionResultSet) {
                    completionResultSet.addElement(LookupElementBuilder.create("suggestion"))
                }
            }
        )
    }
}