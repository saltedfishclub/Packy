# Repository

This page will introduce some elements used to describe a standard Packy Repository.

# Where to host

*But wait, where can I host my repository?*  
Repositories don't require too complex conditions to host.  
Just host it at some static sites, such as GitHub Pages, Netlify, Vercel, etc.

# Repository Metadata

All packy implementations need metadata(packy.json) to identify a repository.

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
  "repo_dir": "myRepoDirName",
  "url": "https://github.com/PackyPowered/ExampleRepository",
  "channels": {
    "stable": [
      {
        "ver": [
          "0.1.0"
        ],
        "requirement": {
          "java": ">= 8"
        }
      }
    ]
  }
}
```  

`provides`, `requirement`, `url` and  `type` is optional. Additionally, `repo_dir` has a default value, `.packy_repo`

With this completed, we can continue our journey to metadata for versions.

# Folder Structure
```
.
├── packy.json
└── .packy_repo
    └── versions
        └── 0.1.0
            ├── MyPlugin.jar
            └── resources.zip

3 directories, 3 files
```

# Version Metadata

Easier than before.

```json
{
  "deps": [
    "depend >=1.0.0 & <=2.0.0"
  ],
  "softdeps": [
    "softdepend ^0.1.0"
  ],
  "configurations": [
    {
      "id": "food",
      "name": "What do you like to eat",
      "matches": ".*",
      "suggest": "taco",
      "override": true
    }
  ],
  "conflicts":[
    "conflict ~1.3 | (1.4.* & !=1.4.5) | ~2"
  ],
  "resources": [
    {
      "fileName": "install.js",
      "fileHash": "sha256(data)"
    }
  ]
}
```
`resources`, `conflicts`, `deps`, `softdeps`, `configurations` are optional. Actually, it could be an empty json.

## Explanation

1. `deps`
`deps` are **dependencies** coordinates with their version DSL.

2. `softdeps`
Similarly with `deps` but these are optional and will install earlier than this package in the same install request.

3. `configurations`
Sometimes we'll need some parameters from user input, that's it, and which could used in the installer script  
`override` means it would be a global parameter for these installers, be careful to use it.

4. `conflicts`
Just like it's name.

5. `resources`
All resources required by this version, always required by validators.

# Version Files
Although packy doesn't have a limitation for files, we still had some promises.

## Promises

- For Installer: `installer.js`
- For UnInstaller: `uninstaller.js` (optional but warn)
- For License: `license.txt` (optional)

About [Extra Scripts](./ExtraScript.md)  
About [Installer](./Installer.md)