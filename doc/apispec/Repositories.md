# Repository

This page will introduce some elements used to describe a standard Packy Repository.

# Where to host

*But wait, where can I host my repository?*  
Repositories don't require too complex conditions to host.  
Just host it at some static sites, such as GitHub Pages, Netlify, Vercel, etc.

# Repository Metadata

All packy implementations need metadata to identify a repository.

Example:
```json
{
 "name": "repository name",
  "maintainers": [
    "icebear67@sfclub.cc"
  ],
  "description": "This is a example package!",
  "type": "NORMAL",
  "provides": [
    "protocollib"
  ],
  "url": "https://github.com/PackyPowered/ExampleRepository",
  "channels": {
    "stable": [
      {
        "ver": "0.1.0",
        "requirement": {
          "java": ">= 8"
        }
      }
    ]
  }
}
```