/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.repository;

import java.io.InputStream;
import java.util.Date;
import java.util.zip.ZipInputStream;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.ProcessApplicationInterface;

/**
 * <p>Builder for a {@link ProcessApplication} deployment</p>
 *
 * <p>A process application is different from a regular deployment.
 * Besides deploying a set of process definitions to the database,
 * the process application has a set of non-database side effects which do not
 * survive an application server restart. These side effects are:
 * <ul>
 * <li>The process engine will exeute all process definitions contained in the deployment
 * in the context of the process application (by calling the process application's
 * {@link ProcessApplicationInterface#execute(java.util.concurrent.Callable)} method.</li>
 * <li>
 * </ul>
 *
 * <p>
 *
 * @author Daniel Meyer
 *
 */
public interface ProcessApplicationDeploymentBuilder extends DeploymentBuilder {

  ProcessApplicationDeploymentBuilder resumePreviousVersions();

  /* {@inheritDoc} */
  ProcessApplicationDeployment deploy();

  // overridden methods //////////////////////////////

  /* {@inheritDoc} */
  ProcessApplicationDeploymentBuilder addInputStream(String resourceName, InputStream inputStream);
  /* {@inheritDoc} */
  ProcessApplicationDeploymentBuilder addClasspathResource(String resource);
  /* {@inheritDoc} */
  ProcessApplicationDeploymentBuilder addString(String resourceName, String text);
  /* {@inheritDoc} */
  ProcessApplicationDeploymentBuilder addZipInputStream(ZipInputStream zipInputStream);
  /* {@inheritDoc} */
  ProcessApplicationDeploymentBuilder name(String name);
  /* {@inheritDoc} */
  ProcessApplicationDeploymentBuilder enableDuplicateFiltering();
  /* {@inheritDoc} */
  ProcessApplicationDeploymentBuilder activateProcessDefinitionsOn(Date date);

}
