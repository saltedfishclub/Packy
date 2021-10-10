# Database Structure

Table: `t_packy_cachemeta`
| key | value|
| - | - |
| time | db_lastUpdated_time |
| channel | channel |

Table: `t_packy_packages`
| packageName | description | metadataId | latestVersion | outdated |
| - | - | - | - |
| ncsb | sbnc | 1 | false |

Table: `t_packy_metadata`
| metadataId | versions | lastUpdateTime | repoUrl |
| - | - | - | - |
| 1 | [a,b,c] | timestampHere | https://.... |