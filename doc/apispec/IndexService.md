# Index Service

## Download Cache (LRU)
Packy introduced caches for decreasing server pressure.
To download a cache db: `GET %channel_root%/cache` (302 Redirect)  

Packy's `LRU Caches` is implemented as several SQLite Databases. [Click here](./LRU_Cache_Structure.md) for further information.

## Search All Repos
Packy will ask Index Service for uncached packages.  

`GET %channel_root%/search?keyword=....`

Response:  
```json
[
  {
    "name": "packageName",
    "versions": [
      "..."
    ],
    "description": "....",
    "repoUrl": "https://....",
    "outdated": false
  }
]
```

## Validation
When Packy was ready to validate downloaded files.  

`GET %channel_root%/%package_name%/%version%/%file_name%.sig`  

For `404` or invalid signature: Not Validated.

## GPG PubKey Download

`GET %channel_root%/pub.asc`

Caching until it expires.
