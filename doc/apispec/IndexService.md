# Index Service

## Download Cache (LRU)
Packy introduced caches to release server pressure.
To download a cache db: `GET %channel_root%/cache` (302 Redirect)  

Packy's `LRU Caches` is implemented by several SQLite Databases. [Click here](./LRU_Cache_Structure.md) to get further details.

## Search All Repos
Packy will request Index Service to get uncached packages.  

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
When Packy is ready to validate the downloaded files, this api will return a GPG signature to the Packy Client.

`GET %channel_root%/%package_name%/%version%/%file_name%.sig`  

For `404` or invalid signature: Not Validated.

## GPG PubKey Download
This api will return a GPG pubkey to the Packy Client.

`GET %channel_root%/pub.asc`

Caching until it expires.
