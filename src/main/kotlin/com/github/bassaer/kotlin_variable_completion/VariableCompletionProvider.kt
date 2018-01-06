package main.kotlin.com.github.bassaer.kotlin_variable_completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.search.PsiShortNamesCache
import com.intellij.util.ProcessingContext

/**
 * Provide all Java class name for completion
 * Created by nakayama on 2018/01/06.
 */
class VariableCompletionProvider : CompletionProvider<CompletionParameters>() {

    private val suggestions = HashSet<String>()

    override fun addCompletions(completionParameters: CompletionParameters,
                                processingContext: ProcessingContext?,
                                completionResultSet: CompletionResultSet) {

        val project = completionParameters.position.containingFile.project

        PsiShortNamesCache.getInstance(project).allClassNames.forEach { className ->
            (className[0].toLowerCase() + className.substring(1)).let {
                if (completionResultSet.prefixMatcher.isStartMatch(it)) {
                    suggestions.add(it)
                }
            }
        }

        suggestions.forEach {
            completionResultSet.addElement(LookupElementBuilder.create(it))
        }

    }
}