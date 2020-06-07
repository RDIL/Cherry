package rocks.rdil.simpleconfig

@DslMarker
annotation class AnnotationDsl

@AnnotationDsl
@Target(AnnotationTarget.FIELD)
annotation class Configuration(val alt: String = "")
