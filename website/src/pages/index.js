import React from "react"
import classnames from "classnames"
import Layout from "@theme/Layout"
import Link from "@docusaurus/Link"
import useBaseUrl from "@docusaurus/useBaseUrl"
import styles from "./styles.module.css"

const features = [
  {
    title: <>Easy to Use</>,
    description: (
      <>
        We have a number of features, which you can use with one click. No
        advanced setup, no long processes.
      </>
    ),
  },
  {
    title: <>Fast</>,
    description: (
      <>
        Built on{" "}
        <a href="https://fabricmc.net" target="_blank">
          Fabric
        </a>
        , Cherry is extremely light-weight and fast. We promise you, no lag, no
        crashes, none of that.
      </>
    ),
  },
  {
    title: <>Extensible</>,
    description: (
      <>
        If you want to use Cherry with your own mods, go for it. We have
        OptiFine support, as well as documentation on adding your own mods in
        roughly 5 clicks.
      </>
    ),
  },
]

function Feature({ title, description }) {
  return (
    <div className={"col col--4"}>
      <h3>{title}</h3>
      <p>{description}</p>
    </div>
  )
}

function Home() {
  return (
    <Layout
      title={`Welcome`}
      description="Description will go into a meta tag in <head />"
    >
      <header className={classnames("hero hero--primary", styles.heroBanner)}>
        <div className="container">
          <h1 className="hero__title">Cherry Client</h1>
          <p className="hero__subtitle">
            The Cherry Minecraft client for 1.14.4!
          </p>
          <div className={styles.buttons}>
            <Link
              className={"button button--outline button--lg"}
              to={useBaseUrl("docs/")}
            >
              Download
            </Link>
          </div>
        </div>
      </header>
      <main>
        {features && features.length > 0 && (
          <section className={styles.features}>
            <div className="container">
              <div className="row">
                {features.map((props, idx) => (
                  <Feature key={idx} {...props} />
                ))}
              </div>
            </div>
          </section>
        )}
      </main>
    </Layout>
  )
}

export default Home
