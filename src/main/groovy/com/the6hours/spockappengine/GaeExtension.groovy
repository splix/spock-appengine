package com.the6hours.spockappengine

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo

/**
 *
 * @author Igor Artamonov (http://igorartamonov.com)
 * @since 16.03.13
 */
class GaeExtension extends AbstractAnnotationDrivenExtension<WithGae> {

    @Override
    void visitSpecAnnotation(WithGae annotation, SpecInfo spec) {
    }

    @Override
    void visitFeatureAnnotation(WithGae annotation, FeatureInfo feature) {
    }

    @Override
    void visitSpec(SpecInfo spec) {
        super.visitSpec(spec)
        spec.addListener(new GaeExtensionListener())
    }
}
