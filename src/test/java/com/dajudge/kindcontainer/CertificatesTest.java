/*
Copyright 2020-2021 Alex Stockinger

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.dajudge.kindcontainer;

import org.junit.Test;

import static com.dajudge.kindcontainer.TestUtils.stringResource;
import static org.junit.Assert.assertTrue;

public class CertificatesTest extends BaseKindContainerTest {
    @Test
    public void adds_custom_certificate() {
        final String allCerts = K8S.copyFileFromContainer(
                "/etc/ssl/certs/ca-certificates.crt",
                TestUtils::readString
        );
        assertTrue(allCerts.contains(stringResource("test.crt")));
    }
}