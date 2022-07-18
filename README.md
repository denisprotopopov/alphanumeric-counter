# Welcome

### github-standard-labels [![stability][0]][1]


### This is AlphaNumeric counter library.

If you need generate sequence IDs like

    AAAAAAAAAAAAAAAA
    AAAAAAAAAAAAAAAB
    AAAAAAAAAAAAAAAC
    ...
    ASFG345SVSFRREVV
    ...
    9999999999999999

This uses characters sequence: [ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789]

How to use:

    SixteenGenerator generator = SixteenGenerator.getInstance() - will start from default value AAAAAAAAAAAAAAAA
    Or
    SixteenGenerator generator = SixteenGenerator.getInstance({started_value})
    
    generator.next();

[0]: https://img.shields.io/badge/stability-experimental-orange.svg?style=flat-square
[1]: https://nodejs.org/api/documentation.html#documentation_stability_index
