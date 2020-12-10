def determineVersion(String branchName, String productionBranchName, String gitCommit) {
  pom = readMavenPom file: 'pom.xml'
  versionPrefix = ""
  if(!branchName.equals(productionBranchName) ) {
    imageVersion = "dev-"
  }
  pomVersion = 1 //pom.version.replaceAll('-SNAPSHOT','').replaceAll('\\.','_')
  buildTimestamp = new Date(currentBuild.startTimeInMillis).format("yyyyMMdd_HH")
  gitHashShort = sh(returnStdout: true, script: "printf \$(git rev-parse --short ${gitCommit})")
  imageVersion = versionPrefix + pomVersion+ "-" + buildTimestamp + "-" + gitHashShort
  imageVersion
}



def gitPush(String targetRepo, String projectName, String projectEnvironment, String projectVersion, String folder) {
  env.FOLDER_REPO = projectName + "/" + projectEnvironment
  env.CHECKOUT_FOLDER = "/tmp/gitrepo"
  sh """
    git clone ${targetRepo} ${CHECKOUT_FOLDER}
    mkdir -p ${CHECKOUT_FOLDER}/${FOLDER_REPO}
    rm -rf ${CHECKOUT_FOLDER}/${FOLDER_REPO}/*
    cp -R ${folder}/* ${CHECKOUT_FOLDER}/${FOLDER_REPO}/
    cd ${CHECKOUT_FOLDER}
    git add -A
    git commit -m "${projectName} in der Version ${projectVersion} für Umgebung ${projectEnvironment} bereitgestellt"
    git pull
    git push
    mkdir ${workspace}/tmp
    git rev-parse HEAD > ${workspace}/tmp/commit
    rm -rf ${CHECKOUT_FOLDER}
  """
  def commit = readFile "tmp/commit"
  commit
}