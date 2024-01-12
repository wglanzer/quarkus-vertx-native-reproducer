# quarkus-vertx-native-reproducer

## console error during native build

```
[1/8] Initializing...                                                                                    (7,8s @ 0,13GB)
 Java version: 21.0.1+12, vendor version: GraalVM CE 21.0.1+12.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3
 C compiler: cc (apple, x86_64, 15.0.0)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 4 user-specific feature(s):
 - com.oracle.svm.thirdparty.gson.GsonFeature
 - io.quarkus.caffeine.runtime.graal.CacheConstructorsFeature
 - io.quarkus.runner.Feature: Auto-generated class by Quarkus from the existing extensions
 - io.quarkus.runtime.graal.DisableLoggingFeature: Disables INFO logging during the analysis phase
------------------------------------------------------------------------------------------------------------------------
 3 experimental option(s) unlocked:
 - '-H:+AllowFoldMethods' (origin(s): command line)
 - '-H:BuildOutputJSONFile' (origin(s): command line)
 - '-H:-UseServiceLoaderFeature' (origin(s): command line)
------------------------------------------------------------------------------------------------------------------------
Build resources:
 - 12,09GB of memory (75,6% of 16,00GB system memory, determined at start)
 - 12 thread(s) (100,0% of 12 available processor(s), determined at start)
[2/8] Performing analysis...  [*****]                                                                   (26,4s @ 0,56GB)
    7.634 reachable types   (84,8% of    9.004 total)
    9.895 reachable fields  (53,5% of   18.483 total)
   36.328 reachable methods (57,2% of   63.555 total)
    2.458 types,    93 fields, and 2.431 methods registered for reflection
       60 types,    59 fields, and    55 methods registered for JNI access
        5 native libraries: -framework CoreServices, -framework Foundation, dl, pthread, z

------------------------------------------------------------------------------------------------------------------------
                       3,6s (10,1% of total time) in 105 GCs | Peak RSS: 1,22GB | CPU load: 7,78
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 /Users/w.glanzer/Development/quarkus-vertx-native-reproducer/target/quarkus-vertx-native-reproducer-native-image-source-jar/quarkus-vertx-native-reproducer-runner-build-output-stats.json (build_info)
========================================================================================================================
Finished generating 'quarkus-vertx-native-reproducer-runner' in 34,5s.
Error: Discovered unresolved type during parsing: io.vertx.core.Vertx. This error is reported at image build time because class io.quarkus.cache.runtime.CacheResultInterceptor is registered for linking at image build time by command line and command line.
Error encountered while parsing io.quarkus.cache.runtime.CacheResultInterceptor.intercept(CacheResultInterceptor.java:39) 
Parsing context:
   at io.quarkus.cache.runtime.CacheResultInterceptor_Bean.intercept(Unknown Source)
   at io.quarkus.arc.impl.InterceptorInvocation.invoke(InterceptorInvocation.java:42)
   at io.quarkus.arc.impl.AroundInvokeInvocationContext.perform(AroundInvokeInvocationContext.java:30)
   at com.github.wglanzer.reproducer.DemoApp_Subclass.run(Unknown Source)
   at root method.(Unknown Source)

Detailed message:

com.oracle.svm.core.util.UserError$UserException: Discovered unresolved type during parsing: io.vertx.core.Vertx. This error is reported at image build time because class io.quarkus.cache.runtime.CacheResultInterceptor is registered for linking at image build time by command line and command line.
Error encountered while parsing io.quarkus.cache.runtime.CacheResultInterceptor.intercept(CacheResultInterceptor.java:39) 
Parsing context:
   at io.quarkus.cache.runtime.CacheResultInterceptor_Bean.intercept(Unknown Source)
   at io.quarkus.arc.impl.InterceptorInvocation.invoke(InterceptorInvocation.java:42)
   at io.quarkus.arc.impl.AroundInvokeInvocationContext.perform(AroundInvokeInvocationContext.java:30)
   at com.github.wglanzer.reproducer.DemoApp_Subclass.run(Unknown Source)
   at root method.(Unknown Source)

Detailed message:

	at org.graalvm.nativeimage.builder/com.oracle.svm.core.util.UserError.abort(UserError.java:85)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.FallbackFeature.reportAsFallback(FallbackFeature.java:248)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGenerator.runPointsToAnalysis(NativeImageGenerator.java:814)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGenerator.doRun(NativeImageGenerator.java:592)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGenerator.run(NativeImageGenerator.java:550)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGeneratorRunner.buildImage(NativeImageGeneratorRunner.java:538)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGeneratorRunner.build(NativeImageGeneratorRunner.java:720)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGeneratorRunner.start(NativeImageGeneratorRunner.java:142)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGeneratorRunner.main(NativeImageGeneratorRunner.java:97)
Caused by: com.oracle.graal.pointsto.constraints.UnsupportedFeatureException: Discovered unresolved type during parsing: io.vertx.core.Vertx. This error is reported at image build time because class io.quarkus.cache.runtime.CacheResultInterceptor is registered for linking at image build time by command line and command line.
Error encountered while parsing io.quarkus.cache.runtime.CacheResultInterceptor.intercept(CacheResultInterceptor.java:39) 
Parsing context:
   at io.quarkus.cache.runtime.CacheResultInterceptor_Bean.intercept(Unknown Source)
   at io.quarkus.arc.impl.InterceptorInvocation.invoke(InterceptorInvocation.java:42)
   at io.quarkus.arc.impl.AroundInvokeInvocationContext.perform(AroundInvokeInvocationContext.java:30)
   at com.github.wglanzer.reproducer.DemoApp_Subclass.run(Unknown Source)
   at root method.(Unknown Source)

Detailed message:

	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.constraints.UnsupportedFeatures.report(UnsupportedFeatures.java:126)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.NativeImageGenerator.runPointsToAnalysis(NativeImageGenerator.java:809)
	... 6 more
Caused by: com.oracle.graal.pointsto.constraints.UnresolvedElementException: Discovered unresolved type during parsing: io.vertx.core.Vertx. This error is reported at image build time because class io.quarkus.cache.runtime.CacheResultInterceptor is registered for linking at image build time by command line and command line.
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.reportUnresolvedElement(SharedGraphBuilderPhase.java:548)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.reportUnresolvedElement(SharedGraphBuilderPhase.java:542)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.handleUnresolvedType(SharedGraphBuilderPhase.java:434)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.handleUnresolvedMethod(SharedGraphBuilderPhase.java:462)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.handleUnresolvedInvoke(SharedGraphBuilderPhase.java:366)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.genInvokeStatic(BytecodeParser.java:1698)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.genInvokeStatic(BytecodeParser.java:1677)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.processBytecode(BytecodeParser.java:5441)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.iterateBytecodesForBlock(BytecodeParser.java:3431)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.iterateBytecodesForBlock(SharedGraphBuilderPhase.java:741)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.handleBytecodeBlock(BytecodeParser.java:3391)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.processBlock(BytecodeParser.java:3233)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.build(BytecodeParser.java:1137)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.build(SharedGraphBuilderPhase.java:161)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.buildRootMethod(BytecodeParser.java:1029)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.GraphBuilderPhase$Instance.run(GraphBuilderPhase.java:101)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase.run(SharedGraphBuilderPhase.java:115)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.run(Phase.java:49)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.BasePhase.apply(BasePhase.java:434)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.apply(Phase.java:42)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.apply(Phase.java:38)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.AnalysisParsedGraph.parseBytecode(AnalysisParsedGraph.java:146)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.meta.AnalysisMethod.parseGraph(AnalysisMethod.java:895)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.meta.AnalysisMethod.ensureGraphParsedHelper(AnalysisMethod.java:860)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.meta.AnalysisMethod.ensureGraphParsed(AnalysisMethod.java:843)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.parse(MethodTypeFlowBuilder.java:186)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.apply(MethodTypeFlowBuilder.java:621)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.createFlowsGraph(MethodTypeFlow.java:167)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.ensureFlowsGraphCreated(MethodTypeFlow.java:153)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.getOrCreateMethodFlowsGraphInfo(MethodTypeFlow.java:111)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.typestate.DefaultVirtualInvokeTypeFlow.onObservedUpdate(DefaultVirtualInvokeTypeFlow.java:113)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.TypeFlow.update(TypeFlow.java:620)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.PointsToAnalysis$1.run(PointsToAnalysis.java:491)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.CompletionExecutor.executeCommand(CompletionExecutor.java:187)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.CompletionExecutor.lambda$executeService$0(CompletionExecutor.java:171)
	at java.base/java.util.concurrent.ForkJoinTask$RunnableExecuteAction.exec(ForkJoinTask.java:1423)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:387)
	at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1312)
	at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1843)
	at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1808)
	at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:188)

```