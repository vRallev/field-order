package com.squareup.anvil.test

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

class SomeClass {
  @Inject lateinit var ccc: String
  @Inject lateinit var bbb: CharSequence
  @Inject lateinit var aaa: List<String>
}

@Module
class MyModule {
  @Provides fun provideString(): String = "abc"
  @Provides fun provideChar(): CharSequence = "def"
  @Provides fun provideList(): List<String> = emptyList()
}

@Singleton
@Component(modules = [MyModule::class])
interface AppComponent {
  fun inject(clazz: SomeClass)
  fun inject(clazz: JavaClass)
}