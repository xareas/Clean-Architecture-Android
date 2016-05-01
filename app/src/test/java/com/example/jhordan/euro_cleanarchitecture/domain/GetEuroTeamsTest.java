/*
 * Copyright (C) 2016 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jhordan.euro_cleanarchitecture.domain;

import com.example.jhordan.euro_cleanarchitecture.data.repository.TeamsRepository;
import com.example.jhordan.euro_cleanarchitecture.domain.usecase.GetEuroTeams;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class GetEuroTeamsTest {

  private GetEuroTeams getEuroTeams;

  @Mock TeamsRepository repository;

  @Before public void setUp() {
    MockitoAnnotations.initMocks(this);
    getEuroTeams = givenATeamListUseCase();
  }

  @Test public void givenAConcreteUseCaseOfGetEuroTeam() {
    assertThat(getEuroTeams, instanceOf(GetEuroTeams.class));
  }

  @Test public void getTeamListObservableFromRepository() {
    getEuroTeams.buildObservableUseCase();
    verify(repository).teamList();
    verifyNoMoreInteractions(repository);
  }

  private GetEuroTeams givenATeamListUseCase() {
    return new GetEuroTeams(repository);
  }
}
