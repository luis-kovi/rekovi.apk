package com.rekovi.taskmanager;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = RekoviApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface RekoviApplication_GeneratedInjector {
  void injectRekoviApplication(RekoviApplication rekoviApplication);
}
