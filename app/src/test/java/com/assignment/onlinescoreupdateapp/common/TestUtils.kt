package com.assignment.onlinescoreupdateapp.common

import com.assignment.onlinescoreupdateapp.data.models.fixuredetails.FixtureDetailsNetworkResponse
import com.assignment.onlinescoreupdateapp.data.models.fixures.FixturesNetworkResponse
import com.assignment.onlinescoreupdateapp.data.models.fixures.toFixtureInfoItem
import com.assignment.onlinescoreupdateapp.domain.models.fixtures.FixtureInfoItem
import com.google.gson.Gson

object TestUtils {
    private val fixtureResponse = """
        [
{
                "kickoff": {
                    "completeness": 3,
                    "millis": 1732564800000,
                    "label": "Mon 25 Nov 2024, 20:00 GMT"
                },
                "teams": [
                    {
                        "team": {
                            "name": "Newcastle United",
                            "club": {
                                "name": "Newcastle United",
                                "abbr": "NEW",
                                "id": 23
                            },
                            "teamType": "FIRST",
                            "shortName": "Newcastle",
                            "id": 23
                        }
                    },
                    {
                        "team": {
                            "name": "West Ham United",
                            "club": {
                                "name": "West Ham United",
                                "abbr": "WHU",
                                "id": 25
                            },
                            "teamType": "FIRST",
                            "shortName": "West Ham",
                            "id": 25
                        }
                    }
                ],
                "ground": {
                    "name": "St. James' Park",
                    "city": "Newcastle",
                    "source": "OPTA",
                    "id": 27
                },
                "status": "U",
                "id": 115945
            },
        {
            "kickoff": {
                "completeness": 3,
                "millis": 1732465800000,
                "label": "Sun 24 Nov 2024, 16:30 GMT"
            },
            "teams": [
                {
                    "team": {
                        "name": "Ipswich Town",
                        "club": {
                            "name": "Ipswich Town",
                            "shortName": "Ipswich",
                            "abbr": "IPS",
                            "id": 8
                        },
                        "teamType": "FIRST",
                        "shortName": "Ipswich",
                        "id": 8,
                        "altIds": {
                            "opta": "t40"
                        }
                    },
                    "score": 1
                },
                {
                    "team": {
                        "name": "Manchester United",
                        "club": {
                            "name": "Manchester United",
                            "shortName": "Man Utd",
                            "abbr": "MUN",
                            "id": 12
                        },
                        "teamType": "FIRST",
                        "shortName": "Man Utd",
                        "id": 12,
                        "altIds": {
                            "opta": "t1"
                        }
                    },
                    "score": 1
                }
            ],
            "ground": {
                "name": "Portman Road",
                "city": "Ipswich",
                "source": "OPTA",
                "id": 66
            },
            "status": "C",
            "attendance": 30017,
            "clock": {
                "secs": 5700,
                "label": "90 +5'00"
            },
            "goals": [
                {
                    "personId": 13565,
                    "assistId": 69176,
                    "clock": {
                        "secs": 120,
                        "label": "02'00"
                    },
                    "phase": "1",
                    "type": "G",
                    "description": "G"
                },
                {
                    "personId": 98300,
                    "assistId": 8201,
                    "clock": {
                        "secs": 2580,
                        "label": "43'00"
                    },
                    "phase": "1",
                    "type": "G",
                    "description": "G"
                }
            ],
            "id": 115942
        },
        {
            "kickoff": {
                "completeness": 3,
                "millis": 1732456800000,
                "label": "Sun 24 Nov 2024, 14:00 GMT"
            },
            "teams": [
                {
                    "team": {
                        "name": "Southampton",
                        "club": {
                            "name": "Southampton",
                            "shortName": "Southampton",
                            "abbr": "SOU",
                            "id": 20
                        },
                        "teamType": "FIRST",
                        "shortName": "Southampton",
                        "id": 20,
                        "altIds": {
                            "opta": "t20"
                        }
                    },
                    "score": 2
                },
                {
                    "team": {
                        "name": "Liverpool",
                        "club": {
                            "name": "Liverpool",
                            "shortName": "Liverpool",
                            "abbr": "LIV",
                            "id": 10
                        },
                        "teamType": "FIRST",
                        "shortName": "Liverpool",
                        "id": 10,
                        "altIds": {
                            "opta": "t14"
                        }
                    },
                    "score": 3
                }
            ],
            "ground": {
                "name": "St. Mary's Stadium",
                "city": "Southampton",
                "source": "OPTA",
                "id": 48
            },
            "status": "I",
            "attendance": 31278,
            "clock": {
                "secs": 3000,
                "label": "50'"
            },
            "goals": [
                {
                    "personId": 33231,
                    "clock": {
                        "secs": 1800,
                        "label": "30'00"
                    },
                    "phase": "1",
                    "type": "G",
                    "description": "G"
                },
                {
                    "personId": 9199,
                    "clock": {
                        "secs": 2520,
                        "label": "42'00"
                    },
                    "phase": "1",
                    "type": "G",
                    "description": "G"
                },
                {
                    "personId": 119072,
                    "assistId": 9199,
                    "clock": {
                        "secs": 3360,
                        "label": "56'00"
                    },
                    "phase": "2",
                    "type": "G",
                    "description": "G"
                },
                {
                    "personId": 5178,
                    "assistId": 49909,
                    "clock": {
                        "secs": 3900,
                        "label": "65'00"
                    },
                    "phase": "2",
                    "type": "G",
                    "description": "G"
                },
                {
                    "personId": 5178,
                    "clock": {
                        "secs": 4980,
                        "label": "83'00"
                    },
                    "phase": "2",
                    "type": "P",
                    "description": "P"
                }
            ],
            "id": 115946
        },
        {
            "kickoff": {
                "completeness": 3,
                "millis": 1732374000000,
                "label": "Sat 23 Nov 2024, 15:00 GMT"
            },
            "teams": [
                {
                    "team": {
                        "name": "Arsenal",
                        "club": {
                            "name": "Arsenal",
                            "shortName": "Arsenal",
                            "abbr": "ARS",
                            "id": 1
                        },
                        "teamType": "FIRST",
                        "shortName": "Arsenal",
                        "id": 1,
                        "altIds": {
                            "opta": "t3"
                        }
                    },
                    "score": 3
                },
                {
                    "team": {
                        "name": "Nottingham Forest",
                        "club": {
                            "name": "Nottingham Forest",
                            "shortName": "Nott'm Forest",
                            "abbr": "NFO",
                            "id": 15
                        },
                        "teamType": "FIRST",
                        "shortName": "Nottm Forest",
                        "id": 15,
                        "altIds": {
                            "opta": "t17"
                        }
                    },
                    "score": 0
                }
            ],
            "ground": {
                "name": "Emirates Stadium",
                "city": "London",
                "source": "OPTA",
                "id": 52
            },
            "status": "C",
            "attendance": 60298,
            "clock": {
                "secs": 5760,
                "label": "90 +6'00"
            },
            "goals": [
                {
                    "personId": 49481,
                    "assistId": 11419,
                    "clock": {
                        "secs": 900,
                        "label": "15'00"
                    },
                    "phase": "1",
                    "type": "G",
                    "description": "G"
                },
                {
                    "personId": 4936,
                    "assistId": 49481,
                    "clock": {
                        "secs": 3120,
                        "label": "52'00"
                    },
                    "phase": "2",
                    "type": "G",
                    "description": "G"
                },
                {
                    "personId": 114566,
                    "assistId": 4316,
                    "clock": {
                        "secs": 5160,
                        "label": "86'00"
                    },
                    "phase": "2",
                    "type": "G",
                    "description": "G"
                }
            ],
            "id": 115937
        },
        {
            "kickoff": {
                "completeness": 3,
                "millis": 1732374000000,
                "label": "Sat 23 Nov 2024, 15:00 GMT"
            },
            "teams": [
                {
                    "team": {
                        "name": "Bournemouth",
                        "club": {
                            "name": "Bournemouth",
                            "shortName": "Bournemouth",
                            "abbr": "BOU",
                            "id": 127
                        },
                        "teamType": "FIRST",
                        "shortName": "Bournemouth",
                        "id": 127,
                        "altIds": {
                            "opta": "t91"
                        }
                    },
                    "score": 1
                },
                {
                    "team": {
                        "name": "Brighton & Hove Albion",
                        "club": {
                            "name": "Brighton and Hove Albion",
                            "shortName": "Brighton",
                            "abbr": "BHA",
                            "id": 131
                        },
                        "teamType": "FIRST",
                        "shortName": "Brighton",
                        "id": 131,
                        "altIds": {
                            "opta": "t36"
                        }
                    },
                    "score": 2
                }
            ],
            "ground": {
                "name": "Vitality Stadium",
                "city": "Bournemouth",
                "source": "OPTA",
                "id": 914
            },
            "status": "C",
            "attendance": 11196,
            "clock": {
                "secs": 5880,
                "label": "90 +8'00"
            },
            "goals": [
                {
                    "personId": 72371,
                    "clock": {
                        "secs": 240,
                        "label": "04'00"
                    },
                    "phase": "1",
                    "type": "G",
                    "description": "G"
                },
                {
                    "personId": 117732,
                    "assistId": 72371,
                    "clock": {
                        "secs": 2940,
                        "label": "49'00"
                    },
                    "phase": "2",
                    "type": "G",
                    "description": "G"
                },
                {
                    "personId": 13706,
                    "assistId": 16582,
                    "clock": {
                        "secs": 5580,
                        "label": "90 +3'00"
                    },
                    "phase": "2",
                    "type": "G",
                    "description": "G"
                }
            ],
            "id": 115939
        }
        ]
    """.trimIndent()

    private val fixtureDetailsResponse = """
        {
            "teams": [
                {
                    "team": {
                        "name": "Southampton",
                        "club": {
                            "name": "Southampton",
                            "shortName": "Southampton",
                            "abbr": "SOU",
                            "id": 20
                        },
                        "teamType": "FIRST",
                        "shortName": "Southampton",
                        "id": 20,
                        "altIds": {
                            "opta": "t20"
                        }
                    },
                    "score": 2
                },
                {
                    "team": {
                        "name": "Liverpool",
                        "club": {
                            "name": "Liverpool",
                            "shortName": "Liverpool",
                            "abbr": "LIV",
                            "id": 10
                        },
                        "teamType": "FIRST",
                        "shortName": "Liverpool",
                        "id": 10,
                        "altIds": {
                            "opta": "t14"
                        }
                    },
                    "score": 3
                }
            ],
            "teamLists": [
                {
                    "teamId": 20,
                    "lineup": [
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 4,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 4,
                                "positionInfo": "Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 916790400000,
                                    "label": "20 January 1999"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                }
                            },
                            "age": "25 years 309 days",
                            "name": {
                                "display": "Flynn Downes",
                                "first": "Flynn",
                                "last": "Downes"
                            },
                            "id": 14383,
                            "altIds": {
                                "opta": "p220585"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 6,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 6,
                                "positionInfo": "Centre Central Defender"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1012348800000,
                                    "label": "30 January 2002"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Stockport"
                            },
                            "age": "22 years 299 days",
                            "name": {
                                "display": "Taylor Harwood-Bellis",
                                "first": "Taylor",
                                "last": "Harwood-Bellis"
                            },
                            "id": 25447,
                            "altIds": {
                                "opta": "p245719"
                            }
                        },
                        {
                            "matchPosition": "G",
                            "matchShirtNumber": 1,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "G",
                                "shirtNum": 1,
                                "positionInfo": "Goalkeeper"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 628646400000,
                                    "label": "3 December 1989"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Guildford"
                            },
                            "age": "34 years 357 days",
                            "name": {
                                "display": "Alex McCarthy",
                                "first": "Alex",
                                "last": "McCarthy"
                            },
                            "id": 4573,
                            "altIds": {
                                "opta": "p58376"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 18,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 18,
                                "positionInfo": "Centre Central Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "PT",
                                "country": "Portugal",
                                "demonym": "Portugese"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1089417600000,
                                    "label": "10 July 2004"
                                },
                                "country": {
                                    "isoCode": "PT",
                                    "country": "Portugal",
                                    "demonym": "Portugese"
                                },
                                "place": "Olhão"
                            },
                            "age": "20 years 137 days",
                            "name": {
                                "display": "Mateus Fernandes",
                                "first": "Mateus Gonçalo",
                                "last": "Espanha Fernandes"
                            },
                            "id": 119072,
                            "altIds": {
                                "opta": "p551226"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 5,
                            "captain": true,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 35,
                                "positionInfo": "Centre/Right Full Back"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 759628800000,
                                    "label": "27 January 1994"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                }
                            },
                            "age": "30 years 302 days",
                            "name": {
                                "display": "Jack Stephens",
                                "first": "Jack",
                                "last": "Stephens"
                            },
                            "id": 4612,
                            "altIds": {
                                "opta": "p88900"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 10,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 10,
                                "positionInfo": "Left/Centre Attacking Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 579225600000,
                                    "label": "10 May 1988"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "St Albans"
                            },
                            "age": "36 years 198 days",
                            "name": {
                                "display": "Adam Lallana",
                                "first": "Adam",
                                "middle": "David",
                                "last": "Lallana"
                            },
                            "id": 4618,
                            "altIds": {
                                "opta": "p39155"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 24,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 24,
                                "positionInfo": "Left/Right Winger"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-SCT",
                                "country": "Scotland",
                                "demonym": "Scottish"
                            },
                            "birth": {
                                "date": {
                                    "millis": 762048000000,
                                    "label": "24 February 1994"
                                },
                                "country": {
                                    "isoCode": "GB-SCT",
                                    "country": "Scotland",
                                    "demonym": "Scottish"
                                },
                                "place": "Aberdeen"
                            },
                            "age": "30 years 274 days",
                            "name": {
                                "display": "Ryan Fraser",
                                "first": "Ryan",
                                "last": "Fraser"
                            },
                            "id": 8052,
                            "altIds": {
                                "opta": "p90105"
                            }
                        },
                        {
                            "matchPosition": "F",
                            "matchShirtNumber": 32,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "F",
                                "shirtNum": 32,
                                "positionInfo": "Forward"
                            },
                            "nationalTeam": {
                                "isoCode": "NG",
                                "country": "Nigeria",
                                "demonym": "Nigerian"
                            },
                            "birth": {
                                "date": {
                                    "millis": 770083200000,
                                    "label": "28 May 1994"
                                },
                                "country": {
                                    "isoCode": "NG",
                                    "country": "Nigeria",
                                    "demonym": "Nigerian"
                                },
                                "place": "Owerri"
                            },
                            "age": "30 years 180 days",
                            "name": {
                                "display": "Paul Onuachu",
                                "first": "Paul",
                                "last": "Onuachu"
                            },
                            "id": 15713,
                            "altIds": {
                                "opta": "p147611"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 33,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 33,
                                "positionInfo": "Left/Centre/Right Attacking Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1140134400000,
                                    "label": "17 February 2006"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Exeter"
                            },
                            "age": "18 years 281 days",
                            "name": {
                                "display": "Tyler Dibling",
                                "first": "Tyler",
                                "last": "Dibling"
                            },
                            "id": 112917,
                            "altIds": {
                                "opta": "p496661"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 2,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 2,
                                "positionInfo": "Right Full Back"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 860889600000,
                                    "label": "13 April 1997"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "London"
                            },
                            "age": "27 years 225 days",
                            "name": {
                                "display": "Kyle Walker-Peters",
                                "first": "Kyle",
                                "last": "Walker-Peters"
                            },
                            "id": 13815,
                            "altIds": {
                                "opta": "p158534"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 9,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "F",
                                "shirtNum": 9,
                                "positionInfo": "Centre Striker"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 855532800000,
                                    "label": "10 February 1997"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                }
                            },
                            "age": "27 years 288 days",
                            "name": {
                                "display": "Adam Armstrong",
                                "first": "Adam",
                                "last": "Armstrong"
                            },
                            "id": 9199,
                            "altIds": {
                                "opta": "p155511"
                            }
                        }
                    ],
                    "substitutes": [
                        {
                            "matchPosition": "G",
                            "matchShirtNumber": 13,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "G",
                                "shirtNum": 13,
                                "positionInfo": "Goalkeeper"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 792806400000,
                                    "label": "15 February 1995"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                }
                            },
                            "age": "29 years 283 days",
                            "name": {
                                "display": "Joe Lumley",
                                "first": "Joe",
                                "middle": "Patrick",
                                "last": "Lumley"
                            },
                            "id": 9462,
                            "altIds": {
                                "opta": "p167888"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 7,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 7,
                                "positionInfo": "Central Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "NG",
                                "country": "Nigeria",
                                "demonym": "Nigerian"
                            },
                            "birth": {
                                "date": {
                                    "millis": 837907200000,
                                    "label": "21 July 1996"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "London"
                            },
                            "age": "28 years 126 days",
                            "name": {
                                "display": "Joe Aribo",
                                "first": "Joe",
                                "middle": "Oluwaseyi Temitope",
                                "last": "Aribo"
                            },
                            "id": 13956,
                            "altIds": {
                                "opta": "p193204"
                            }
                        },
                        {
                            "matchPosition": "F",
                            "matchShirtNumber": 17,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "F",
                                "shirtNum": 17,
                                "positionInfo": "Left Winger"
                            },
                            "nationalTeam": {
                                "isoCode": "CL",
                                "country": "Chile",
                                "demonym": "Chilean"
                            },
                            "birth": {
                                "date": {
                                    "millis": 924393600000,
                                    "label": "18 April 1999"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Stoke-on-Trent"
                            },
                            "age": "25 years 220 days",
                            "name": {
                                "display": "Ben Brereton",
                                "first": "Ben",
                                "last": "Brereton"
                            },
                            "id": 14242,
                            "altIds": {
                                "opta": "p204814"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 26,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 26,
                                "positionInfo": "Centre Defensive Midfielder",
                                "loan": true
                            },
                            "nationalTeam": {
                                "isoCode": "FR",
                                "country": "France",
                                "demonym": "French"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1080259200000,
                                    "label": "26 March 2004"
                                },
                                "country": {
                                    "isoCode": "FR",
                                    "country": "France",
                                    "demonym": "French"
                                },
                                "place": "Rennes"
                            },
                            "age": "20 years 243 days",
                            "name": {
                                "display": "Lesley Ugochukwu",
                                "first": "Lesley",
                                "last": "Ugochukwu"
                            },
                            "id": 74960,
                            "altIds": {
                                "opta": "p503714"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 3,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 3,
                                "positionInfo": "Left Full Back"
                            },
                            "nationalTeam": {
                                "isoCode": "IE",
                                "country": "Ireland",
                                "demonym": "Irish"
                            },
                            "birth": {
                                "date": {
                                    "millis": 834710400000,
                                    "label": "14 June 1996"
                                },
                                "country": {
                                    "isoCode": "IE",
                                    "country": "Ireland",
                                    "demonym": "Irish"
                                },
                                "place": "Galway"
                            },
                            "age": "28 years 163 days",
                            "name": {
                                "display": "Ryan Manning",
                                "first": "Ryan",
                                "last": "Manning"
                            },
                            "id": 14252,
                            "altIds": {
                                "opta": "p204863"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 20,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 20,
                                "positionInfo": "Left Winger"
                            },
                            "nationalTeam": {
                                "isoCode": "GH",
                                "country": "Ghana",
                                "demonym": "Ghanan"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1013731200000,
                                    "label": "15 February 2002"
                                },
                                "country": {
                                    "isoCode": "GH",
                                    "country": "Ghana",
                                    "demonym": "Ghanan"
                                }
                            },
                            "age": "22 years 283 days",
                            "name": {
                                "display": "Kamaldeen Sulemana",
                                "first": "Kamaldeen",
                                "last": "Sulemana"
                            },
                            "id": 123910,
                            "altIds": {
                                "opta": "p504783"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 14,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 14,
                                "positionInfo": "Right Full Back"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 881798400000,
                                    "label": "11 December 1997"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Wakefield"
                            },
                            "age": "26 years 349 days",
                            "name": {
                                "display": "James Bree",
                                "first": "James",
                                "middle": "Patrick",
                                "last": "Bree"
                            },
                            "id": 10565,
                            "altIds": {
                                "opta": "p184386"
                            }
                        },
                        {
                            "matchPosition": "F",
                            "matchShirtNumber": 19,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "F",
                                "shirtNum": 19,
                                "positionInfo": "Forward"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1007856000000,
                                    "label": "9 December 2001"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Walsall"
                            },
                            "age": "22 years 351 days",
                            "name": {
                                "display": "Cameron Archer",
                                "first": "Cameron",
                                "last": "Archer"
                            },
                            "id": 25281,
                            "altIds": {
                                "opta": "p433979"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 16,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 16,
                                "positionInfo": "Right Full Back"
                            },
                            "nationalTeam": {
                                "isoCode": "JP",
                                "country": "Japan",
                                "demonym": "Japanese"
                            },
                            "birth": {
                                "date": {
                                    "millis": 962150400000,
                                    "label": "28 June 2000"
                                },
                                "country": {
                                    "isoCode": "JP",
                                    "country": "Japan",
                                    "demonym": "Japanese"
                                }
                            },
                            "age": "24 years 149 days",
                            "name": {
                                "display": "Yukinari Sugawara",
                                "first": "Yukinari",
                                "last": "Sugawara"
                            },
                            "id": 67238,
                            "altIds": {
                                "opta": "p219279"
                            }
                        }
                    ],
                    "formation": {
                        "label": "5-4-1",
                        "players": [
                            [
                                4573
                            ],
                            [
                                13815,
                                25447,
                                14383,
                                4612,
                                8052
                            ],
                            [
                                112917,
                                119072,
                                4618,
                                9199
                            ],
                            [
                                15713
                            ]
                        ]
                    }
                },
                {
                    "teamId": 10,
                    "lineup": [
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 4,
                            "captain": true,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 4,
                                "positionInfo": "Centre Central Defender"
                            },
                            "nationalTeam": {
                                "isoCode": "NL",
                                "country": "Netherlands",
                                "demonym": "Dutch"
                            },
                            "birth": {
                                "date": {
                                    "millis": 678931200000,
                                    "label": "8 July 1991"
                                },
                                "country": {
                                    "isoCode": "NL",
                                    "country": "Netherlands",
                                    "demonym": "Dutch"
                                },
                                "place": "Breda"
                            },
                            "age": "33 years 139 days",
                            "name": {
                                "display": "Virgil van Dijk",
                                "first": "Virgil",
                                "last": "van Dijk"
                            },
                            "id": 5140,
                            "altIds": {
                                "opta": "p97032"
                            }
                        },
                        {
                            "matchPosition": "G",
                            "matchShirtNumber": 62,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "G",
                                "shirtNum": 62,
                                "positionInfo": "Goalkeeper"
                            },
                            "nationalTeam": {
                                "isoCode": "IE",
                                "country": "Ireland",
                                "demonym": "Irish"
                            },
                            "birth": {
                                "date": {
                                    "millis": 911779200000,
                                    "label": "23 November 1998"
                                },
                                "country": {
                                    "isoCode": "IE",
                                    "country": "Ireland",
                                    "demonym": "Irish"
                                },
                                "place": "Cork"
                            },
                            "age": "26 years 1 day",
                            "name": {
                                "display": "Caoimhín Kelleher",
                                "first": "Caoimhín",
                                "last": "Kelleher"
                            },
                            "id": 14723,
                            "altIds": {
                                "opta": "p200720"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 8,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 8,
                                "positionInfo": "Left/Centre/Right Attacking Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "HU",
                                "country": "Hungary",
                                "demonym": "Hungarian"
                            },
                            "birth": {
                                "date": {
                                    "millis": 972432000000,
                                    "label": "25 October 2000"
                                },
                                "country": {
                                    "isoCode": "HU",
                                    "country": "Hungary",
                                    "demonym": "Hungarian"
                                },
                                "place": "Székesfehérvár"
                            },
                            "age": "24 years 30 days",
                            "name": {
                                "display": "Dominik Szoboszlai",
                                "first": "Dominik",
                                "last": "Szoboszlai"
                            },
                            "id": 33231,
                            "altIds": {
                                "opta": "p424876"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 38,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 38,
                                "positionInfo": "Centre Central Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "NL",
                                "country": "Netherlands",
                                "demonym": "Dutch"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1021507200000,
                                    "label": "16 May 2002"
                                },
                                "country": {
                                    "isoCode": "NL",
                                    "country": "Netherlands",
                                    "demonym": "Dutch"
                                },
                                "place": "Amsterdam"
                            },
                            "age": "22 years 192 days",
                            "name": {
                                "display": "Ryan Gravenberch",
                                "first": "Ryan",
                                "last": "Gravenberch"
                            },
                            "id": 49909,
                            "altIds": {
                                "opta": "p441266"
                            }
                        },
                        {
                            "matchPosition": "F",
                            "matchShirtNumber": 9,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "F",
                                "shirtNum": 9,
                                "positionInfo": "Centre Striker"
                            },
                            "nationalTeam": {
                                "isoCode": "UY",
                                "country": "Uruguay",
                                "demonym": "Uruguayan"
                            },
                            "birth": {
                                "date": {
                                    "millis": 930182400000,
                                    "label": "24 June 1999"
                                },
                                "country": {
                                    "isoCode": "UY",
                                    "country": "Uruguay",
                                    "demonym": "Uruguayan"
                                },
                                "place": "Artigas"
                            },
                            "age": "25 years 153 days",
                            "name": {
                                "display": "Darwin Núñez",
                                "first": "Darwin",
                                "middle": "Gabriel",
                                "last": "Núñez"
                            },
                            "id": 70287,
                            "altIds": {
                                "opta": "p447203"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 26,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 26,
                                "positionInfo": "Left Full Back"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-SCT",
                                "country": "Scotland",
                                "demonym": "Scottish"
                            },
                            "birth": {
                                "date": {
                                    "millis": 763344000000,
                                    "label": "11 March 1994"
                                },
                                "country": {
                                    "isoCode": "GB-SCT",
                                    "country": "Scotland",
                                    "demonym": "Scottish"
                                },
                                "place": "Glasgow"
                            },
                            "age": "30 years 258 days",
                            "name": {
                                "display": "Andy Robertson",
                                "first": "Andy",
                                "last": "Robertson"
                            },
                            "id": 10458,
                            "altIds": {
                                "opta": "p122798"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 84,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 84,
                                "positionInfo": "Right Full Back"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-NIR",
                                "country": "Northern Ireland",
                                "demonym": "Northern Irish"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1057708800000,
                                    "label": "9 July 2003"
                                },
                                "country": {
                                    "isoCode": "GB-NIR",
                                    "country": "Northern Ireland",
                                    "demonym": "Northern Irish"
                                },
                                "place": "Castlederg"
                            },
                            "age": "21 years 138 days",
                            "name": {
                                "display": "Conor Bradley",
                                "first": "Conor",
                                "last": "Bradley"
                            },
                            "id": 68582,
                            "altIds": {
                                "opta": "p492777"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 18,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "F",
                                "shirtNum": 18,
                                "positionInfo": "Centre Striker"
                            },
                            "nationalTeam": {
                                "isoCode": "NL",
                                "country": "Netherlands",
                                "demonym": "Dutch"
                            },
                            "birth": {
                                "date": {
                                    "millis": 926035200000,
                                    "label": "7 May 1999"
                                },
                                "country": {
                                    "isoCode": "NL",
                                    "country": "Netherlands",
                                    "demonym": "Dutch"
                                },
                                "place": "Eindhoven"
                            },
                            "age": "25 years 201 days",
                            "name": {
                                "display": "Cody Gakpo",
                                "first": "Cody",
                                "last": "Gakpo"
                            },
                            "id": 32894,
                            "altIds": {
                                "opta": "p243298"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 5,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 5,
                                "positionInfo": "Centre Central Defender"
                            },
                            "nationalTeam": {
                                "isoCode": "FR",
                                "country": "France",
                                "demonym": "French"
                            },
                            "birth": {
                                "date": {
                                    "millis": 927590400000,
                                    "label": "25 May 1999"
                                },
                                "country": {
                                    "isoCode": "FR",
                                    "country": "France",
                                    "demonym": "French"
                                },
                                "place": "Paris"
                            },
                            "age": "25 years 183 days",
                            "name": {
                                "display": "Ibrahima Konaté",
                                "first": "Ibrahima",
                                "last": "Konaté"
                            },
                            "id": 23593,
                            "altIds": {
                                "opta": "p204716"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 17,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 17,
                                "positionInfo": "Centre Central Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 980812800000,
                                    "label": "30 January 2001"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Liverpool"
                            },
                            "age": "23 years 299 days",
                            "name": {
                                "display": "Curtis Jones",
                                "first": "Curtis",
                                "last": "Jones"
                            },
                            "id": 23815,
                            "altIds": {
                                "opta": "p206915"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 11,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "F",
                                "shirtNum": 11,
                                "positionInfo": "Left/Centre/Right Winger"
                            },
                            "nationalTeam": {
                                "isoCode": "EG",
                                "country": "Egypt",
                                "demonym": "Egyptian"
                            },
                            "birth": {
                                "date": {
                                    "millis": 708566400000,
                                    "label": "15 June 1992"
                                },
                                "country": {
                                    "isoCode": "EG",
                                    "country": "Egypt",
                                    "demonym": "Egyptian"
                                },
                                "place": "Nagrig"
                            },
                            "age": "32 years 162 days",
                            "name": {
                                "display": "Mohamed Salah",
                                "first": "Mohamed",
                                "last": "Salah Hamed Mahrous Ghaly"
                            },
                            "id": 5178,
                            "altIds": {
                                "opta": "p118748"
                            }
                        }
                    ],
                    "substitutes": [
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 80,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 80,
                                "positionInfo": "Centre Central Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1036022400000,
                                    "label": "31 October 2002"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Wallasey"
                            },
                            "age": "22 years 24 days",
                            "name": {
                                "display": "Tyler Morton",
                                "first": "Tyler",
                                "last": "Morton"
                            },
                            "id": 51574,
                            "altIds": {
                                "opta": "p440148"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 10,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 10,
                                "positionInfo": "Left/Centre/Right Attacking Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "AR",
                                "country": "Argentina"
                            },
                            "birth": {
                                "date": {
                                    "millis": 914457600000,
                                    "label": "24 December 1998"
                                },
                                "country": {
                                    "isoCode": "AR",
                                    "country": "Argentina"
                                },
                                "place": "Santa Rosa"
                            },
                            "age": "25 years 336 days",
                            "name": {
                                "display": "Alexis Mac Allister",
                                "first": "Alexis",
                                "last": "Mac Allister"
                            },
                            "id": 63633,
                            "altIds": {
                                "opta": "p243016"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 78,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 78,
                                "positionInfo": "Centre Central Defender"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1043798400000,
                                    "label": "29 January 2003"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Warrington"
                            },
                            "age": "21 years 300 days",
                            "name": {
                                "display": "Jarell Quansah",
                                "first": "Jarell",
                                "last": "Quansah"
                            },
                            "id": 51557,
                            "altIds": {
                                "opta": "p441428"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 3,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 3,
                                "positionInfo": "Centre Defensive Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "JP",
                                "country": "Japan",
                                "demonym": "Japanese"
                            },
                            "birth": {
                                "date": {
                                    "millis": 729216000000,
                                    "label": "9 February 1993"
                                },
                                "country": {
                                    "isoCode": "JP",
                                    "country": "Japan",
                                    "demonym": "Japanese"
                                },
                                "place": "Yokohama"
                            },
                            "age": "31 years 289 days",
                            "name": {
                                "display": "Wataru Endo",
                                "first": "Wataru",
                                "last": "Endo"
                            },
                            "id": 43586,
                            "altIds": {
                                "opta": "p158983"
                            }
                        },
                        {
                            "matchPosition": "G",
                            "matchShirtNumber": 56,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "G",
                                "shirtNum": 56,
                                "positionInfo": "Goalkeeper"
                            },
                            "nationalTeam": {
                                "isoCode": "CZ",
                                "country": "Czech Republic",
                                "demonym": "Czech"
                            },
                            "birth": {
                                "date": {
                                    "millis": 995846400000,
                                    "label": "23 July 2001"
                                },
                                "country": {
                                    "isoCode": "CZ",
                                    "country": "Czech Republic",
                                    "demonym": "Czech"
                                },
                                "place": "Pribram"
                            },
                            "age": "23 years 124 days",
                            "name": {
                                "display": "Vítezslav Jaros",
                                "first": "Vítezslav",
                                "last": "Jaros"
                            },
                            "id": 24807,
                            "altIds": {
                                "opta": "p432987"
                            }
                        },
                        {
                            "matchPosition": "F",
                            "matchShirtNumber": 7,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "F",
                                "shirtNum": 7,
                                "positionInfo": "Left/Right Winger"
                            },
                            "nationalTeam": {
                                "isoCode": "CO",
                                "country": "Colombia",
                                "demonym": "Colombian"
                            },
                            "birth": {
                                "date": {
                                    "millis": 853113600000,
                                    "label": "13 January 1997"
                                },
                                "country": {
                                    "isoCode": "CO",
                                    "country": "Colombia",
                                    "demonym": "Colombian"
                                },
                                "place": "Barrancas"
                            },
                            "age": "27 years 316 days",
                            "name": {
                                "display": "Luis Díaz",
                                "first": "Luis",
                                "last": "Díaz"
                            },
                            "id": 66669,
                            "altIds": {
                                "opta": "p244731"
                            }
                        },
                        {
                            "matchPosition": "M",
                            "matchShirtNumber": 19,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "M",
                                "shirtNum": 19,
                                "positionInfo": "Centre/Right Attacking Midfielder"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1049414400000,
                                    "label": "4 April 2003"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Chertsey"
                            },
                            "age": "21 years 234 days",
                            "name": {
                                "display": "Harvey Elliott",
                                "first": "Harvey",
                                "middle": "Daniel James",
                                "last": "Elliott"
                            },
                            "id": 33185,
                            "altIds": {
                                "opta": "p444884"
                            }
                        },
                        {
                            "matchPosition": "D",
                            "matchShirtNumber": 2,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "D",
                                "shirtNum": 2,
                                "positionInfo": "Left/Centre/Right Central Defender"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 864345600000,
                                    "label": "23 May 1997"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "London"
                            },
                            "age": "27 years 185 days",
                            "name": {
                                "display": "Joe Gomez",
                                "first": "Joe",
                                "last": "Gomez"
                            },
                            "id": 10651,
                            "altIds": {
                                "opta": "p171287"
                            }
                        },
                        {
                            "matchPosition": "G",
                            "matchShirtNumber": 95,
                            "captain": false,
                            "playerId": 0,
                            "info": {
                                "position": "G",
                                "shirtNum": 95,
                                "positionInfo": "Goalkeeper"
                            },
                            "nationalTeam": {
                                "isoCode": "GB-ENG",
                                "country": "England",
                                "demonym": "English"
                            },
                            "birth": {
                                "date": {
                                    "millis": 1062547200000,
                                    "label": "3 September 2003"
                                },
                                "country": {
                                    "isoCode": "GB-ENG",
                                    "country": "England",
                                    "demonym": "English"
                                },
                                "place": "Liverpool"
                            },
                            "age": "21 years 82 days",
                            "name": {
                                "display": "Harvey Davies",
                                "first": "Harvey",
                                "last": "Davies"
                            },
                            "id": 68581,
                            "altIds": {
                                "opta": "p464353"
                            }
                        }
                    ],
                    "formation": {
                        "label": "4-2-3-1",
                        "players": [
                            [
                                14723
                            ],
                            [
                                68582,
                                23593,
                                5140,
                                10458
                            ],
                            [
                                49909,
                                23815
                            ],
                            [
                                5178,
                                33231,
                                32894
                            ],
                            [
                                70287
                            ]
                        ]
                    }
                }
            ],
            "status": "C",
            "matchOfficials": [
                {
                    "matchOfficialId": 148879,
                    "role": "MAIN",
                    "birth": {},
                    "name": {
                        "display": "Samuel Barrott",
                        "first": "Samuel",
                        "last": "Barrott"
                    },
                    "id": 21346
                },
                {
                    "matchOfficialId": 148880,
                    "birth": {},
                    "name": {
                        "display": "Lee Betts",
                        "first": "Lee",
                        "last": "Betts"
                    },
                    "id": 16997
                },
                {
                    "matchOfficialId": 148881,
                    "birth": {},
                    "name": {
                        "display": "Wade Smith",
                        "first": "Wade",
                        "last": "Smith"
                    },
                    "id": 24429
                },
                {
                    "matchOfficialId": 148882,
                    "role": "FOURTH_OFFICIAL",
                    "birth": {},
                    "name": {
                        "display": "Darren England",
                        "first": "Darren",
                        "last": "England"
                    },
                    "id": 16986
                },
                {
                    "matchOfficialId": 148883,
                    "role": "VAR",
                    "birth": {},
                    "name": {
                        "display": "Michael Oliver",
                        "first": "Michael",
                        "last": "Oliver"
                    },
                    "id": 16963
                },
                {
                    "matchOfficialId": 148884,
                    "role": "ASSISTANT_VAR",
                    "birth": {},
                    "name": {
                        "display": "Matt Wilkes",
                        "first": "Matt",
                        "last": "Wilkes"
                    },
                    "id": 16976
                }
            ],
            "kickoff": {
                "completeness": 3,
                "millis": 1732456800000,
                "label": "Sun 24 Nov 2024, 14:00 GMT"
            },
            "id": 115946,
            "halfTimeScore": {
                "homeScore": 1,
                "awayScore": 1
            },
            "ground": {
                "name": "St. Mary's Stadium",
                "city": "Southampton",
                "source": "OPTA",
                "id": 48
            },
            "events": [
                {
                    "clock": {
                        "secs": 0,
                        "label": "00'00"
                    },
                    "phase": "1",
                    "type": "PS",
                    "time": {
                        "millis": 1732456808000,
                        "label": "24 November 2024, 14:00"
                    },
                    "score": {
                        "homeScore": 0,
                        "awayScore": 0
                    }
                },
                {
                    "id": 207399,
                    "personId": 68582,
                    "teamId": 10,
                    "clock": {
                        "secs": 780,
                        "label": "13'00"
                    },
                    "phase": "1",
                    "type": "B",
                    "description": "Y",
                    "time": {
                        "millis": 1732457588000,
                        "label": "24 November 2024, 14:13"
                    },
                    "score": {
                        "homeScore": 0,
                        "awayScore": 0
                    }
                },
                {
                    "id": 207401,
                    "personId": 23593,
                    "teamId": 10,
                    "clock": {
                        "secs": 960,
                        "label": "16'00"
                    },
                    "phase": "1",
                    "type": "B",
                    "description": "Y",
                    "time": {
                        "millis": 1732457768000,
                        "label": "24 November 2024, 14:16"
                    },
                    "score": {
                        "homeScore": 0,
                        "awayScore": 0
                    }
                },
                {
                    "id": 207402,
                    "personId": 4618,
                    "teamId": 20,
                    "clock": {
                        "secs": 1380,
                        "label": "23'00"
                    },
                    "phase": "1",
                    "type": "B",
                    "description": "Y",
                    "time": {
                        "millis": 1732458188000,
                        "label": "24 November 2024, 14:23"
                    },
                    "score": {
                        "homeScore": 0,
                        "awayScore": 0
                    }
                },
                {
                    "id": 164728,
                    "personId": 33231,
                    "teamId": 10,
                    "clock": {
                        "secs": 1800,
                        "label": "30'00"
                    },
                    "phase": "1",
                    "type": "G",
                    "description": "G",
                    "time": {
                        "millis": 1732458608000,
                        "label": "24 November 2024, 14:30"
                    },
                    "score": {
                        "homeScore": 0,
                        "awayScore": 1
                    }
                },
                {
                    "id": 345485,
                    "personId": 13956,
                    "teamId": 20,
                    "clock": {
                        "secs": 2220,
                        "label": "37'00"
                    },
                    "phase": "1",
                    "type": "S",
                    "description": "ON",
                    "time": {
                        "millis": 1732459028000,
                        "label": "24 November 2024, 14:37"
                    },
                    "score": {
                        "homeScore": 0,
                        "awayScore": 1
                    }
                },
                {
                    "id": 345485,
                    "personId": 4618,
                    "teamId": 20,
                    "clock": {
                        "secs": 2220,
                        "label": "37'00"
                    },
                    "phase": "1",
                    "type": "S",
                    "description": "OFF",
                    "time": {
                        "millis": 1732459028000,
                        "label": "24 November 2024, 14:37"
                    },
                    "score": {
                        "homeScore": 0,
                        "awayScore": 1
                    }
                },
                {
                    "id": 164730,
                    "personId": 9199,
                    "teamId": 20,
                    "clock": {
                        "secs": 2520,
                        "label": "42'00"
                    },
                    "phase": "1",
                    "type": "G",
                    "description": "G",
                    "time": {
                        "millis": 1732459328000,
                        "label": "24 November 2024, 14:42"
                    },
                    "score": {
                        "homeScore": 1,
                        "awayScore": 1
                    }
                },
                {
                    "id": 9860,
                    "personId": 9199,
                    "teamId": 20,
                    "clock": {
                        "secs": 2520,
                        "label": "42'00"
                    },
                    "phase": "1",
                    "type": "SP",
                    "description": "SP",
                    "time": {
                        "millis": 1732459328000,
                        "label": "24 November 2024, 14:42"
                    },
                    "score": {
                        "homeScore": 1,
                        "awayScore": 1
                    }
                },
                {
                    "clock": {
                        "secs": 3120,
                        "label": "45 +7'00"
                    },
                    "phase": "1",
                    "type": "PE",
                    "time": {
                        "millis": 1732459871000,
                        "label": "24 November 2024, 14:51"
                    },
                    "score": {
                        "homeScore": 1,
                        "awayScore": 1
                    }
                },
                {
                    "clock": {
                        "secs": 2700,
                        "label": "45'00"
                    },
                    "phase": "2",
                    "type": "PS",
                    "time": {
                        "millis": 1732460829000,
                        "label": "24 November 2024, 15:07"
                    },
                    "score": {
                        "homeScore": 1,
                        "awayScore": 1
                    }
                },
                {
                    "id": 207409,
                    "personId": 32894,
                    "teamId": 10,
                    "clock": {
                        "secs": 2940,
                        "label": "49'00"
                    },
                    "phase": "2",
                    "type": "B",
                    "description": "Y",
                    "time": {
                        "millis": 1732461069000,
                        "label": "24 November 2024, 15:11"
                    },
                    "score": {
                        "homeScore": 1,
                        "awayScore": 1
                    }
                },
                {
                    "id": 345491,
                    "personId": 74960,
                    "teamId": 20,
                    "clock": {
                        "secs": 3120,
                        "label": "52'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "ON",
                    "time": {
                        "millis": 1732461249000,
                        "label": "24 November 2024, 15:14"
                    },
                    "score": {
                        "homeScore": 1,
                        "awayScore": 1
                    }
                },
                {
                    "id": 345491,
                    "personId": 15713,
                    "teamId": 20,
                    "clock": {
                        "secs": 3120,
                        "label": "52'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "OFF",
                    "time": {
                        "millis": 1732461249000,
                        "label": "24 November 2024, 15:14"
                    },
                    "score": {
                        "homeScore": 1,
                        "awayScore": 1
                    }
                },
                {
                    "id": 164732,
                    "personId": 119072,
                    "teamId": 20,
                    "assistId": 9199,
                    "clock": {
                        "secs": 3360,
                        "label": "56'00"
                    },
                    "phase": "2",
                    "type": "G",
                    "description": "G",
                    "time": {
                        "millis": 1732461489000,
                        "label": "24 November 2024, 15:18"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 1
                    }
                },
                {
                    "id": 345492,
                    "personId": 63633,
                    "teamId": 10,
                    "clock": {
                        "secs": 3720,
                        "label": "62'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "ON",
                    "time": {
                        "millis": 1732461849000,
                        "label": "24 November 2024, 15:24"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 1
                    }
                },
                {
                    "id": 345492,
                    "personId": 23815,
                    "teamId": 10,
                    "clock": {
                        "secs": 3720,
                        "label": "62'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "OFF",
                    "time": {
                        "millis": 1732461849000,
                        "label": "24 November 2024, 15:24"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 1
                    }
                },
                {
                    "id": 345493,
                    "personId": 66669,
                    "teamId": 10,
                    "clock": {
                        "secs": 3720,
                        "label": "62'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "ON",
                    "time": {
                        "millis": 1732461849000,
                        "label": "24 November 2024, 15:24"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 1
                    }
                },
                {
                    "id": 345493,
                    "personId": 32894,
                    "teamId": 10,
                    "clock": {
                        "secs": 3720,
                        "label": "62'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "OFF",
                    "time": {
                        "millis": 1732461849000,
                        "label": "24 November 2024, 15:24"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 1
                    }
                },
                {
                    "id": 164733,
                    "personId": 5178,
                    "teamId": 10,
                    "assistId": 49909,
                    "clock": {
                        "secs": 3900,
                        "label": "65'00"
                    },
                    "phase": "2",
                    "type": "G",
                    "description": "G",
                    "time": {
                        "millis": 1732462029000,
                        "label": "24 November 2024, 15:27"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 2
                    }
                },
                {
                    "id": 207411,
                    "personId": 9199,
                    "teamId": 20,
                    "clock": {
                        "secs": 4380,
                        "label": "73'00"
                    },
                    "phase": "2",
                    "type": "B",
                    "description": "Y",
                    "time": {
                        "millis": 1732462509000,
                        "label": "24 November 2024, 15:35"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 2
                    }
                },
                {
                    "id": 345494,
                    "personId": 25281,
                    "teamId": 20,
                    "clock": {
                        "secs": 4620,
                        "label": "77'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "ON",
                    "time": {
                        "millis": 1732462749000,
                        "label": "24 November 2024, 15:39"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 2
                    }
                },
                {
                    "id": 345494,
                    "personId": 9199,
                    "teamId": 20,
                    "clock": {
                        "secs": 4620,
                        "label": "77'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "OFF",
                    "time": {
                        "millis": 1732462749000,
                        "label": "24 November 2024, 15:39"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 2
                    }
                },
                {
                    "id": 345495,
                    "personId": 67238,
                    "teamId": 20,
                    "clock": {
                        "secs": 4620,
                        "label": "77'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "ON",
                    "time": {
                        "millis": 1732462749000,
                        "label": "24 November 2024, 15:39"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 2
                    }
                },
                {
                    "id": 345495,
                    "personId": 8052,
                    "teamId": 20,
                    "clock": {
                        "secs": 4620,
                        "label": "77'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "OFF",
                    "time": {
                        "millis": 1732462749000,
                        "label": "24 November 2024, 15:39"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 2
                    }
                },
                {
                    "id": 164735,
                    "personId": 5178,
                    "teamId": 10,
                    "clock": {
                        "secs": 4980,
                        "label": "83'00"
                    },
                    "phase": "2",
                    "type": "P",
                    "description": "P",
                    "time": {
                        "millis": 1732463109000,
                        "label": "24 November 2024, 15:45"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 3
                    }
                },
                {
                    "id": 207413,
                    "personId": 5178,
                    "teamId": 10,
                    "clock": {
                        "secs": 5040,
                        "label": "84'00"
                    },
                    "phase": "2",
                    "type": "B",
                    "description": "Y",
                    "time": {
                        "millis": 1732463169000,
                        "label": "24 November 2024, 15:46"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 3
                    }
                },
                {
                    "id": 345496,
                    "personId": 43586,
                    "teamId": 10,
                    "clock": {
                        "secs": 5400,
                        "label": "90'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "ON",
                    "time": {
                        "millis": 1732463529000,
                        "label": "24 November 2024, 15:52"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 3
                    }
                },
                {
                    "id": 345496,
                    "personId": 70287,
                    "teamId": 10,
                    "clock": {
                        "secs": 5400,
                        "label": "90'00"
                    },
                    "phase": "2",
                    "type": "S",
                    "description": "OFF",
                    "time": {
                        "millis": 1732463529000,
                        "label": "24 November 2024, 15:52"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 3
                    }
                },
                {
                    "id": 207417,
                    "personId": 4612,
                    "teamId": 20,
                    "clock": {
                        "secs": 5880,
                        "label": "90 +8'00"
                    },
                    "phase": "2",
                    "type": "B",
                    "description": "Y",
                    "time": {
                        "millis": 1732464009000,
                        "label": "24 November 2024, 16:00"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 3
                    }
                },
                {
                    "clock": {
                        "secs": 5940,
                        "label": "90 +9'00"
                    },
                    "phase": "2",
                    "type": "PE",
                    "time": {
                        "millis": 1732464016000,
                        "label": "24 November 2024, 16:00"
                    },
                    "score": {
                        "homeScore": 2,
                        "awayScore": 3
                    }
                }
            ],
            "clock": {
                "secs": 5940,
                "label": "90 +9'00"
            },
            "attendance": 31278
        }
    """.trimIndent()

    fun getFixtures(): List<FixtureInfoItem> = Gson().fromJson<FixturesNetworkResponse>(
        fixtureResponse,
        FixturesNetworkResponse::class.java
    ).map {
        it.toFixtureInfoItem()
    }

    fun getFixturesNetworkResponse(): FixturesNetworkResponse =
        Gson().fromJson<FixturesNetworkResponse>(
            fixtureResponse,
            FixturesNetworkResponse::class.java
        )

    fun getFixturesDetailsNetworkResponse(): FixtureDetailsNetworkResponse =
        Gson().fromJson<FixtureDetailsNetworkResponse>(
            fixtureDetailsResponse,
            FixtureDetailsNetworkResponse::class.java
        )

}