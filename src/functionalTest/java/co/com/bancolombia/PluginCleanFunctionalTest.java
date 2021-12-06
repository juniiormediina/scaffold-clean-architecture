/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package co.com.bancolombia;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.file.SimplePathVisitor;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.TaskOutcome;
import org.junit.Before;
import org.junit.Test;

/** A simple functional test for the 'co.com.bancolombia.greeting' plugin. */
public class PluginCleanFunctionalTest {

  public static final String BUILD_FUNCTIONAL_TEST_README_MD = "build/functionalTest/README.md";
  public static final String BUILD_FUNCTIONAL_TEST_GITIGNORE = "build/functionalTest/.gitignore";
  public static final String BUILD_FUNCTIONAL_TEST_BUILD_GRADLE = "build/functionalTest/build.gradle";
  public static final String BUILD_FUNCTIONAL_TEST_MAIN_GRADLE = "build/functionalTest/main.gradle";
  public static final String BUILD_FUNCTIONAL_TEST_SETTINGS_GRADLE = "build/functionalTest/settings.gradle";
  public static final String BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_DRIVEN_ADAPTERS = "build/functionalTest/infrastructure/driven-adapters/";
  public static final String BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS = "build/functionalTest/infrastructure/entry-points";
  public static final String BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_HELPERS = "build/functionalTest/infrastructure/helpers";
  public static final String BUILD_FUNCTIONAL_TEST_DOMAIN_MODEL_BUILD_GRADLE = "build/functionalTest/domain/model/build.gradle";
  public static final String BUILD_FUNCTIONAL_TEST_DOMAIN_USECASE_BUILD_GRADLE = "build/functionalTest/domain/usecase/build.gradle";
  public static final String BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_BUILD_GRADLE = "build/functionalTest/applications/app-service/build.gradle";
  public static final String BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_SRC_MAIN_RESOURCES_APPLICATION_YAML = "build/functionalTest/applications/app-service/src/main/resources/application.yaml";
  public static final String BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_SRC_MAIN_RESOURCES_LOG_4_J_2_PROPERTIES = "build/functionalTest/applications/app-service/src/main/resources/log4j2.properties";
  public static final String GENERATE_DRIVEN_ADAPTER = "generateDrivenAdapter";
  public static final String TYPE = "--type=";
  public static final String NAME = "--name=";
  public static final String GENERATE_ENTRY_POINT = "generateEntryPoint";
  public static final String GRAPHQLPATH = "/graphqlpath";
  public static final String BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_SRC_MAIN_JAVA_CO_COM_BANCOLOMBIA_API_API_REST_JAVA = "build/functionalTest/infrastructure/entry-points/api-rest/src/main/java/co/com/bancolombia/api/ApiRest.java";
  public static final String BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_BUILD_GRADLE = "build/functionalTest/infrastructure/entry-points/api-rest/build.gradle";
  public static final String COMPILE_EXCLUDE_GROUP_ORG_SPRINGFRAMEWORK_BOOT_MODULE_SPRING_BOOT_STARTER_TOMCAT = "compile.exclude group: \"org.springframework.boot\", module:\"spring-boot-starter-tomcat\"";
  public static final String ASYNCEVENTBUS = "ASYNCEVENTBUS";
  public static final String RESTMVC = "restmvc";
  public static final String SERVER = "--server=";
  public static final String VALIDATE_STRUCTURE = "validateStructure";
  File projectDir = new File("build/functionalTest");
  GradleRunner runner;

  @Before
  public void init() throws IOException {
    // Setup the test build
    deleteStructure(projectDir.toPath());
    Files.createDirectories(projectDir.toPath());
    writeString(new File(projectDir, "settings.gradle"), "");
    writeString(
        new File(projectDir, "build.gradle"),
        "plugins {" + "  id('co.com.bancolombia.cleanArchitecture')" + "}");
    runner = GradleRunner.create();
    runner.forwardOutput();
    runner.withPluginClasspath();
  }

  private void deleteStructure(Path sourcePath) {

    try {
      Files.walkFileTree(
          sourcePath,
          new SimplePathVisitor() {
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
              Files.delete(dir);
              return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs)
                throws IOException {
              Files.delete(file);
              return FileVisitResult.CONTINUE;
            }
          });
    } catch (IOException e) {
      System.out.println("error delete Structure " + e.getMessage());
    }
  }

  @Test
  public void canRunTaskGenerateStructureWithOutLombok() {

    String task = "ca";

    runner.withArguments(task, "--lombok=" + "false");
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    // Verify the resultassertTrue(new File(BUILD_FUNCTIONAL_TEST_README_MD).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_GITIGNORE).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_BUILD_GRADLE).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_MAIN_GRADLE).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_SETTINGS_GRADLE).exists());

    assertTrue(new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_DRIVEN_ADAPTERS).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_HELPERS).exists());

    assertTrue(
        new File("build/functionalTest/domain/model/src/main/java/co/com/bancolombia/model")
            .exists());
    assertTrue(
        new File("build/functionalTest/domain/model/src/test/java/co/com/bancolombia/model")
            .exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_DOMAIN_MODEL_BUILD_GRADLE).exists());
    assertTrue(
        new File("build/functionalTest/domain/usecase/src/main/java/co/com/bancolombia/usecase")
            .exists());
    assertTrue(
        new File("build/functionalTest/domain/usecase/src/test/java/co/com/bancolombia/usecase")
            .exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_DOMAIN_USECASE_BUILD_GRADLE).exists());

    assertTrue(new File(BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_BUILD_GRADLE).exists());
    assertTrue(
        new File(
                "build/functionalTest/applications/app-service/src/main/java/co/com/bancolombia/MainApplication.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/applications/app-service/src/main/java/co/com/bancolombia/config/UseCasesConfig.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/applications/app-service/src/main/java/co/com/bancolombia/config")
            .exists());
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_SRC_MAIN_RESOURCES_APPLICATION_YAML)
            .exists());
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_SRC_MAIN_RESOURCES_LOG_4_J_2_PROPERTIES)
            .exists());
    assertTrue(
        new File("build/functionalTest/applications/app-service/src/test/java/co/com/bancolombia")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateStructureWithOutParameters() {

    String task = "ca";

    runner.withArguments(task);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    // Verify the result
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_README_MD).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_GITIGNORE).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_BUILD_GRADLE).exists());
    assertTrue(new File("build/functionalTest/lombok.config").exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_MAIN_GRADLE).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_SETTINGS_GRADLE).exists());

    assertTrue(new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_DRIVEN_ADAPTERS).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_HELPERS).exists());

    assertTrue(
        new File("build/functionalTest/domain/model/src/main/java/co/com/bancolombia/model")
            .exists());
    assertTrue(
        new File("build/functionalTest/domain/model/src/test/java/co/com/bancolombia/model")
            .exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_DOMAIN_MODEL_BUILD_GRADLE).exists());
    assertTrue(
        new File("build/functionalTest/domain/usecase/src/main/java/co/com/bancolombia/usecase")
            .exists());
    assertTrue(
        new File("build/functionalTest/domain/usecase/src/test/java/co/com/bancolombia/usecase")
            .exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_DOMAIN_USECASE_BUILD_GRADLE).exists());

    assertTrue(new File(BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_BUILD_GRADLE).exists());
    assertTrue(
        new File(
                "build/functionalTest/applications/app-service/src/main/java/co/com/bancolombia/MainApplication.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/applications/app-service/src/main/java/co/com/bancolombia/config/UseCasesConfig.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/applications/app-service/src/main/java/co/com/bancolombia/config")
            .exists());
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_SRC_MAIN_RESOURCES_APPLICATION_YAML)
            .exists());
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_SRC_MAIN_RESOURCES_LOG_4_J_2_PROPERTIES)
            .exists());
    assertTrue(
        new File("build/functionalTest/applications/app-service/src/test/java/co/com/bancolombia")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  public void canRunTaskGenerateStructureWithOutParametersValidator() {

    runner.withArguments("ca", "--lombok=" + "false");
    runner.withProjectDir(projectDir);
    runner.build();

    runner.withArguments(GENERATE_DRIVEN_ADAPTER, TYPE + "jpa");
    runner.withProjectDir(projectDir);
    runner.build();

    runner.withArguments(GENERATE_DRIVEN_ADAPTER, TYPE + "MONGODB");
    runner.withProjectDir(projectDir);
    runner.build();
  }

  public void canRunTaskGenerateStructureReactiveProject() {
    runner.withArguments("ca", "--type=reactive");
    runner.withProjectDir(projectDir);
    runner.build();

    runner.withArguments(GENERATE_DRIVEN_ADAPTER, TYPE + "jpa");
    runner.withProjectDir(projectDir);
    runner.build();

    runner.withArguments(GENERATE_DRIVEN_ADAPTER, TYPE + ASYNCEVENTBUS);
    runner.withProjectDir(projectDir);
    runner.build();
  }

  @Test
  public void canRunTaskGenerateStructureWithParameters() {
    String task = "cleanArchitecture";
    String packageName = "co.com.test";
    String projectName = "ProjectName";

    runner.withArguments(task, NAME + projectName, "--package=" + packageName);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    // Verify the result

    assertTrue(new File(BUILD_FUNCTIONAL_TEST_README_MD).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_GITIGNORE).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_BUILD_GRADLE).exists());
    assertTrue(new File("build/functionalTest/lombok.config").exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_MAIN_GRADLE).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_SETTINGS_GRADLE).exists());

    assertTrue(new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_DRIVEN_ADAPTERS).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS).exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_HELPERS).exists());

    assertTrue(
        new File("build/functionalTest/domain/model/src/main/java/co/com/test/model").exists());
    assertTrue(
        new File("build/functionalTest/domain/model/src/test/java/co/com/test/model").exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_DOMAIN_MODEL_BUILD_GRADLE).exists());
    assertTrue(
        new File("build/functionalTest/domain/usecase/src/main/java/co/com/test/usecase").exists());
    assertTrue(
        new File("build/functionalTest/domain/usecase/src/test/java/co/com/test/usecase").exists());
    assertTrue(new File(BUILD_FUNCTIONAL_TEST_DOMAIN_USECASE_BUILD_GRADLE).exists());

    assertTrue(new File(BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_BUILD_GRADLE).exists());
    assertTrue(
        new File(
                "build/functionalTest/applications/app-service/src/main/java/co/com/test/MainApplication.java")
            .exists());
    assertTrue(
        new File("build/functionalTest/applications/app-service/src/main/java/co/com/test/config")
            .exists());
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_SRC_MAIN_RESOURCES_APPLICATION_YAML)
            .exists());
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_SRC_MAIN_RESOURCES_LOG_4_J_2_PROPERTIES)
            .exists());
    assertTrue(
        new File("build/functionalTest/applications/app-service/src/test/java/co/com/test")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateModelWithParameters() {
    String task = "generateModel";
    String modelName = "testModel";
    canRunTaskGenerateStructureWithOutParameters();

    // Run the build
    runner.withArguments(task, NAME + modelName);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File(
                "build/functionalTest/domain/model/src/main/java/co/com/bancolombia/model/testmodel/gateways/TestModelRepository.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/domain/model/src/main/java/co/com/bancolombia/model/testmodel/TestModel.java")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateUseCaseWithParameters() {
    canRunTaskGenerateStructureWithOutParameters();
    String task = "generateUseCase";
    String useCaseName = "business";

    // Setup the test buildº
    runner.withArguments(task, NAME + useCaseName);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File(
                "build/functionalTest/domain/usecase/src/main/java/co/com/bancolombia/usecase/business/BusinessUseCase.java")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateDrivenAdapterRestConsumerCaseWithParameters() {
    canRunTaskGenerateStructureWithOutParameters();
    String task = GENERATE_DRIVEN_ADAPTER;
    String valueDrivenAdapter = "restconsumer";
    String valueurlDrivenAdapter = "http://localhost:8080";

    runner.withArguments(task, TYPE + valueDrivenAdapter, "--url=" + valueurlDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/rest-consumer/src/main/java/co/com/bancolombia/consumer/RestConsumer.java")
            .exists());
    assertTrue(
        new File("build/functionalTest/infrastructure/driven-adapters/rest-consumer/build.gradle")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateEntryPointGraphqlApiCase() {
    canRunTaskGenerateStructureReactiveProject();
    String task = GENERATE_ENTRY_POINT;
    String valueEntryPoint = "graphql";
    String valuePathgqlEntryPoint = GRAPHQLPATH;

    runner.withArguments(task, TYPE + valueEntryPoint, "--pathgql=" + valuePathgqlEntryPoint);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File("build/functionalTest/infrastructure/entry-points/graphql-api/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/graphql-api/src/main/java/co/com/bancolombia/graphqlapi/ApiQueries.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/graphql-api/src/main/java/co/com/bancolombia/graphqlapi/ApiMutations.java")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateDrivenAdapterRSocketRequesterCase() {
    canRunTaskGenerateStructureReactiveProject();
    String task = GENERATE_DRIVEN_ADAPTER;
    String valueDrivenAdapter = "rsocket";

    runner.withArguments(task, TYPE + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/rsocket-requester/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/rsocket-requester/src/main/java/co/com/bancolombia/rsocket/config/RequesterConfig.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/rsocket-requester/src/main/java/co/com/bancolombia/rsocket/service/RsocketAdapter.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/rsocket-requester/src/test/java/co/com/bancolombia/rsocket/service")
            .exists());
    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateEntryPointRSocketResponderCase() {
    canRunTaskGenerateStructureReactiveProject();
    String task = GENERATE_ENTRY_POINT;
    String valueDrivenAdapter = "rsocket";

    runner.withArguments(task, TYPE + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File("build/functionalTest/infrastructure/entry-points/rsocket-responder/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/rsocket-responder/src/main/java/co/com/bancolombia/controller/RsocketController.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/rsocket-responder/src/test/java/co/com/bancolombia/controller")
            .exists());
    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateEntryPointCaseWithParameters() {
    canRunTaskGenerateStructureWithOutParameters();
    String task = GENERATE_ENTRY_POINT;
    String valueEntryPoint = RESTMVC;

    runner.withArguments(task, TYPE + valueEntryPoint);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_SRC_MAIN_JAVA_CO_COM_BANCOLOMBIA_API_API_REST_JAVA)
            .exists());
    assertTrue(
        new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_BUILD_GRADLE)
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateRestMvcEntryPointCaseWithUndertowServer() throws IOException {
    canRunTaskGenerateStructureWithOutParameters();
    String task = GENERATE_ENTRY_POINT;
    String valueEntryPoint = RESTMVC;
    String server = "undertow";

    runner.withArguments(task, TYPE + valueEntryPoint, SERVER + server);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_SRC_MAIN_JAVA_CO_COM_BANCOLOMBIA_API_API_REST_JAVA)
            .exists());
    assertTrue(
        new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_BUILD_GRADLE)
            .exists());

    assertTrue(
        FileUtils.readFileToString(
                new File(BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_BUILD_GRADLE),
                StandardCharsets.UTF_8)
            .contains("spring-boot-starter-undertow"));
    assertTrue(
        FileUtils.readFileToString(
                new File(BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_BUILD_GRADLE),
                StandardCharsets.UTF_8)
            .contains(
                COMPILE_EXCLUDE_GROUP_ORG_SPRINGFRAMEWORK_BOOT_MODULE_SPRING_BOOT_STARTER_TOMCAT));

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateRestMvcEntryPointCaseWithJettyServer() throws IOException {
    canRunTaskGenerateStructureWithOutParameters();
    String task = GENERATE_ENTRY_POINT;
    String valueEntryPoint = RESTMVC;
    String server = "jetty";

    runner.withArguments(task, TYPE + valueEntryPoint, SERVER + server);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_SRC_MAIN_JAVA_CO_COM_BANCOLOMBIA_API_API_REST_JAVA)
            .exists());
    assertTrue(
        new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_BUILD_GRADLE)
            .exists());

    assertTrue(
        FileUtils.readFileToString(
                new File(BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_BUILD_GRADLE),
                StandardCharsets.UTF_8)
            .contains("spring-boot-starter-jetty"));
    assertTrue(
        FileUtils.readFileToString(
                new File(BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_BUILD_GRADLE),
                StandardCharsets.UTF_8)
            .contains(
                COMPILE_EXCLUDE_GROUP_ORG_SPRINGFRAMEWORK_BOOT_MODULE_SPRING_BOOT_STARTER_TOMCAT));

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateEntryPointCaseWithTomcatServer() throws IOException {
    canRunTaskGenerateStructureWithOutParameters();
    String task = GENERATE_ENTRY_POINT;
    String valueEntryPoint = RESTMVC;
    String server = "tomcat";

    runner.withArguments(task, TYPE + valueEntryPoint, SERVER + server);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    assertTrue(
        new File(
            BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_SRC_MAIN_JAVA_CO_COM_BANCOLOMBIA_API_API_REST_JAVA)
            .exists());
    assertTrue(
        new File(BUILD_FUNCTIONAL_TEST_INFRASTRUCTURE_ENTRY_POINTS_API_REST_BUILD_GRADLE)
            .exists());

    assertFalse(
        FileUtils.readFileToString(
                new File(BUILD_FUNCTIONAL_TEST_APPLICATIONS_APP_SERVICE_BUILD_GRADLE),
                StandardCharsets.UTF_8)
            .contains(
                COMPILE_EXCLUDE_GROUP_ORG_SPRINGFRAMEWORK_BOOT_MODULE_SPRING_BOOT_STARTER_TOMCAT));

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateDrivenAdapterWithParameters() {
    canRunTaskGenerateStructureWithOutParameters();
    String task = GENERATE_DRIVEN_ADAPTER;
    String valueDrivenAdapter = "jpa";

    runner.withArguments(task, TYPE + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File("build/functionalTest/infrastructure/driven-adapters/jpa-repository/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/jpa-repository/src/main/java/co/com/bancolombia/jpa/JPARepository.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/jpa-repository/src/main/java/co/com/bancolombia/jpa/JPARepositoryAdapter.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/jpa-repository/src/main/java/co/com/bancolombia/jpa/helper/AdapterOperations.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/applications/app-service/src/main/java/co/com/bancolombia/config/JpaConfig.java")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateDrivenAdapterEventBusTest() {
    canRunTaskGenerateStructureReactiveProject();
    String task = GENERATE_DRIVEN_ADAPTER;
    String valueDrivenAdapter = ASYNCEVENTBUS;

    runner.withArguments(task, TYPE + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File("build/functionalTest/infrastructure/driven-adapters/async-event-bus/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/async-event-bus/src/main/java/co/com/bancolombia/events/ReactiveEventsGateway.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/async-event-bus/src/main/java/co/com/bancolombia/events/ReactiveDirectAsyncGateway.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/domain/model/src/main/java/co/com/bancolombia/model/events/gateways/EventsGateway.java")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test(expected = Exception.class)
  public void shouldFailTaskGenerateDrivenAdapterEventBusForNonReactiveTest() {
    canRunTaskGenerateStructureWithOutParameters();
    String task = GENERATE_DRIVEN_ADAPTER;
    String valueDrivenAdapter = ASYNCEVENTBUS;

    runner.withArguments(task, TYPE + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    runner.build();
  }

  @Test
  public void canRunTaskGenerateEntryPointEventHandlerTest() {
    canRunTaskGenerateStructureReactiveProject();
    String task = GENERATE_ENTRY_POINT;
    String valueDrivenAdapter = "ASYNCEVENTHANDLER";

    runner.withArguments(task, TYPE + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/async-event-handler/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/async-event-handler/src/main/java/co/com/bancolombia/events/HandlerRegistryConfiguration.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/async-event-handler/src/main/java/co/com/bancolombia/events/handlers/EventsHandler.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/async-event-handler/src/main/java/co/com/bancolombia/events/handlers/CommandsHandler.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/async-event-handler/src/main/java/co/com/bancolombia/events/handlers/QueriesHandler.java")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateDrivenAdapterR2dbcPostgreSQLTest() {
    canRunTaskGenerateStructureReactiveProject();

    String task = GENERATE_DRIVEN_ADAPTER;
    String valueDrivenAdapter = "R2DBC";
    runner.withArguments(task, TYPE + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/r2dbc-postgresql/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/r2dbc-postgresql/src/main/java/co/com/bancolombia/config/PostgreSQLConnectionPool.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/r2dbc-postgresql/src/main/java/co/com/bancolombia/config/PostgresqlConnectionProperties.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/r2dbc-postgresql/src/main/java/co/com/bancolombia/MyReactiveRepository.java")
            .exists());
    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateDrivenAdapterKmsTest() {
    canRunTaskGenerateStructureReactiveProject();

    String task = GENERATE_DRIVEN_ADAPTER;
    String valueDrivenAdapter = "KMS";
    runner.withArguments(task, TYPE + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File("build/functionalTest/infrastructure/driven-adapters/kms-repository/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/kms-repository/src/main/java/co/com/bancolombia/kms/KmsAdapter.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/kms-repository/src/main/java/co/com/bancolombia/kms/config/KmsConfig.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/kms-repository/src/main/java/co/com/bancolombia/kms/config/model/KmsConnectionProperties.java")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateDrivenAdapterS3Test() {
    canRunTaskGenerateStructureWithOutParameters();

    String task = GENERATE_DRIVEN_ADAPTER;
    String valueDrivenAdapter = "S3";
    runner.withArguments(task, TYPE + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File("build/functionalTest/infrastructure/driven-adapters/s3-repository/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/s3-repository/src/main/java/co/com/bancolombia/s3/adapter/S3Adapter.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/s3-repository/src/main/java/co/com/bancolombia/s3/operations/S3Operations.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/s3-repository/src/main/java/co/com/bancolombia/s3/config/S3Config.java")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/s3-repository/src/main/java/co/com/bancolombia/s3/config/model/S3ConnectionProperties.java")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateHelperTest() {
    canRunTaskGenerateStructureWithOutParameters();

    String task = "generateHelper";
    String valueDrivenAdapter = "S3Helper";
    runner.withArguments(task, NAME + valueDrivenAdapter);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File("build/functionalTest/infrastructure/helpers/s3-helper/build.gradle").exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/helpers/s3-helper/src/main/java/co/com/bancolombia/s3helper")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/helpers/s3-helper/src/test/java/co/com/bancolombia/s3helper")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGeneratePipelineAzureDevOpsTest() {
    canRunTaskGenerateStructureWithOutParameters();
    String task = "generatePipeline";
    String valuePipeline = "AZURE";

    runner.withArguments(task, TYPE + valuePipeline);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File("build/functionalTest/deployment/cleanarchitecture_azure_build.yaml").exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskGenerateGithubActionTest() {
    canRunTaskGenerateStructureWithOutParameters();
    String task = "generatePipeline";
    String valuePipeline = "GITHUB";

    runner.withArguments(task, TYPE + valuePipeline);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File(
                "build/functionalTest/.github/workflows/cleanarchitecture_github_action_gradle.yaml")
            .exists());

    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canRunTaskValidateStructureWithOutParameters() {
    canRunTaskGenerateStructureWithOutParametersValidator();
    String task = VALIDATE_STRUCTURE;

    runner.withArguments(task);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    // Verify the result
    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canGetChildProjects() {
    canRunTaskGenerateStructureWithOutParameters();
  }

  @Test
  public void createTasks() {

    runner.withArguments("tasks");
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    // Verify the result
    assertTrue(result.getOutput().contains("cleanArchitecture"));
    assertTrue(result.getOutput().contains("generateModel"));
    assertTrue(result.getOutput().contains(VALIDATE_STRUCTURE));

    assertEquals(result.task(":tasks").getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canDeleteModule() {
    // Arrange
    canRunTaskGenerateDrivenAdapterWithParameters();
    // Act
    runner.withArguments("deleteModule", "--module=jpa-repository");
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    // Assert
    assertFalse(
        new File("build/functionalTest/infrastructure/driven-adapters/jpa-repository").exists());
    assertEquals(result.task(":deleteModule").getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canValidateImperativeProject() {
    canRunTaskGenerateStructureWithOutParametersValidator();
    // Act
    runner.withArguments(VALIDATE_STRUCTURE);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    // Assert
    assertEquals(result.task(":validateStructure").getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void canValidateReactiveProject() {
    canRunTaskGenerateStructureReactiveProject();
    // Act
    runner.withArguments(VALIDATE_STRUCTURE);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();
    // Assert
    assertEquals(result.task(":validateStructure").getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test(expected = Exception.class)
  public void validateStructureReactiveWithInvalidModel() throws IOException {
    canRunTaskGenerateStructureReactiveProject();
    writeString(
        new File(BUILD_FUNCTIONAL_TEST_DOMAIN_MODEL_BUILD_GRADLE),
        "implementation 'org.springframework.boot:spring-boot-starter'");

    // Act
    runner.withArguments(VALIDATE_STRUCTURE);
    runner.withProjectDir(projectDir);
    runner.build();
  }

  @Test(expected = Exception.class)
  public void validateStructureReactiveWithInvalidUseCase() throws IOException {
    canRunTaskGenerateStructureReactiveProject();
    writeString(
        new File(BUILD_FUNCTIONAL_TEST_DOMAIN_USECASE_BUILD_GRADLE),
        "implementation 'org.springframework.boot:spring-boot-starter'");

    // Act
    runner.withArguments(VALIDATE_STRUCTURE);
    runner.withProjectDir(projectDir);
    runner.build();
  }

  @Test
  public void shouldGenerateMQEntryPoint() {
    canRunTaskGenerateStructureReactiveProject();
    String task = GENERATE_ENTRY_POINT;
    String type = "MQ";

    runner.withArguments(task, TYPE + type);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File("build/functionalTest/infrastructure/entry-points/mq-listener/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/entry-points/mq-listener/src/main/java/co/com/bancolombia/mq/listener/SampleMQMessageListener.java")
            .exists());
    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void shouldGenerateMQDrivenAdapter() {
    canRunTaskGenerateStructureReactiveProject();
    String task = GENERATE_DRIVEN_ADAPTER;
    String type = "MQ";

    runner.withArguments(task, TYPE + type);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File("build/functionalTest/infrastructure/driven-adapters/mq-sender/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/mq-sender/src/main/java/co/com/bancolombia/mq/sender/SampleMQMessageSender.java")
            .exists());
    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  @Test
  public void shouldGenerateMQDrivenAdapterNoReactive() {
    canRunTaskGenerateStructureWithOutParameters();
    String task = GENERATE_DRIVEN_ADAPTER;
    String type = "MQ";

    runner.withArguments(task, TYPE + type);
    runner.withProjectDir(projectDir);
    BuildResult result = runner.build();

    assertTrue(
        new File("build/functionalTest/infrastructure/driven-adapters/mq-sender/build.gradle")
            .exists());
    assertTrue(
        new File(
                "build/functionalTest/infrastructure/driven-adapters/mq-sender/src/main/java/co/com/bancolombia/mq/sender/SampleMQMessageSender.java")
            .exists());
    assertEquals(result.task(":" + task).getOutcome(), TaskOutcome.SUCCESS);
  }

  private void writeString(File file, String string) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      writer.write(string);
    }
  }
}
