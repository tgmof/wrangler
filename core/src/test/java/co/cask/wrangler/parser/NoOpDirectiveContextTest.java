/*
 * Copyright © 2017 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.wrangler.parser;

import co.cask.wrangler.api.Directives;
import co.cask.wrangler.api.Step;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Tests {@link NoOpDirectiveContext}
 */
public class NoOpDirectiveContextTest {

  @Test
  public void testNoFilteringHappening() throws Exception {
    String[] text = new String[] {
      "parse-as-csv body , true",
      "drop body",
      "drop Cabin",
      "drop Embarked",
      "fill-null-or-empty Age 0",
      "filter-row-if-true Fare < 8.06"
    };

    Directives directives = new TextDirectives(text);
    List<Step> steps = directives.getSteps();
    Assert.assertEquals(6, steps.size());
  }

}