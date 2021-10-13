# Index Service

## Download Cache (LRU)
Packy introduced caches to release server pressure. To download a cache db: `GET %repo_root%/cache` (302 Redirect)

Packy's `LRU Caches` is implemented by several SQLite Databases. [Click here](./LRU_Cache_Structure.md) to get further
details.

## Search All Repos

Packy will request Index Service to get uncached packages.

`GET %repo_root%/search?keyword=....`

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

## GPG PubKey Download

This api will return a GPG Keyring.

`GET %repo_root%/pub.kr`

Caching until it expires.

## Repository Info

`GET %repo_root%/info`

Response:

```json
{
  "name": "repo_name",
  "arch": "targeted_arch",
  "maintainer": "iceBear 67 <icebear67@sfclub.cc>"
}
```
