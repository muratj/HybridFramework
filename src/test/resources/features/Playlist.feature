Feature: Playlist

  Scenario: Add new playlist
    Given user already logged in
    | email          | password    |
    | test@email.com | te$t$tudent |
    When user clicks on plus button on playlists section
    And input field for new playlist name is appears
    And user enters random playlist name on the input field
    And user press enter button
    Then the playlist will appear on playlists list