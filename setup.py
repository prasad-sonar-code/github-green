from setuptools import setup, find_packages

setup(
    name="githubgreencard",
    version="0.1.0",
    description="Automated DSA Portfolio Engine — daily commit pipeline",
    author="GitHubGreenCard",
    packages=find_packages(),
    install_requires=[
        "openai>=1.0.0",
        "requests>=2.31.0",
        "pyyaml>=6.0",
    ],
    python_requires=">=3.11",
)
