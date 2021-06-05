import os
import json
from flask import make_response


def root_dir():
    """ Returns root director for this project """
    return os.path.realpath('.')


def nice_json(arg):
    response = make_response(json.dumps(arg, sort_keys = True, indent=4))
    response.headers['Content-type'] = "application/json"
    return response
