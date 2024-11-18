# justfile

# Recipe to run the development main entry point
run-dev:
    clj -A:dev -X dev/-main

cljs-storm:
    clj -Sforce -Sdeps '{:deps {com.github.flow-storm/flow-storm-dbg {:mvn/version "RELEASE"}}}' -X flow-storm.debugger.main/start-debugger :repl-type :shadow :build-id :dev :port 7123