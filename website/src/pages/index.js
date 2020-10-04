import React from "react"
import clsx from "clsx"
import Layout from "@theme/Layout"
import styles from "./styles.module.css"
import Link from "@docusaurus/Link"
import useBaseUrl from "@docusaurus/useBaseUrl"

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
        , Cherry is extremely light-weight and fast. We promise you, no extra
        lag, no crashes, none of that.
      </>
    ),
  },
  {
    title: <>Multiple Minecraft Versions</>,
    description: (
      <>
        Cherry supports several Minecraft versions, including 1.14.4, and
        1.15.2!
      </>
    ),
  },
]

function Feature({ title, description }) {
  return (
    <div className="col col--4">
      <h3>{title}</h3>
      <p>{description}</p>
    </div>
  )
}

export default () => {
  return (
    <Layout
      title={"Welcome"}
      description="Welcome to Cherry, a utility Minecraft mod, built off Fabric with love."
    >
      <header className={clsx("hero hero--primary", styles.heroBanner)}>
        <div className="container">
          <h1 className="hero__title">Cherry</h1>
          <p className="hero__subtitle">A utility Minecraft mod.</p>
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
        <section className={styles.button}>
          <Link
            className="button button--primary button--lg"
            to={useBaseUrl("docs/install/")}
          >
            Download
          </Link>
        </section>
      </main>
    </Layout>
  )
}
