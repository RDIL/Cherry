module.exports = {
  title: "Cherry",
  tagline: "The Cherry Minecraft utility mod!",
  url: "https://cherry.rdil.rocks",
  baseUrl: "/",
  favicon: "favicon.ico",
  organizationName: "RDIL",
  projectName: "Cherry",
  themeConfig: {
    navbar: {
      title: "Cherry",
      logo: {
        alt: "Cherry Logo",
        src: "logo.png",
      },
      items: [
        {
          to: "docs/features",
          label: "Features",
          position: "left",
        },
        {
          to: "docs/install",
          label: "Install",
          position: "left",
        },
        {
          href: "https://github.com/RDIL/Cherry",
          label: "GitHub",
          position: "right",
        },
      ],
    },
    footer: {
      style: "dark",
      copyright: `Copyright © ${new Date().getFullYear()} Reece Dunham.`,
    },
  },
  presets: [
    [
      "@docusaurus/preset-classic",
      {
        docs: {
          sidebarPath: require.resolve("./sidebars.js"),
          editUrl: "https://github.com/RDIL/Cherry/edit/master/website/",
          showLastUpdateTime: true,
        },
        theme: {
          customCss: require.resolve("./src/css/custom.css"),
        },
        sitemap: {
          cacheTime: 600 * 1000,
          changefreq: "weekly",
          priority: 0.5,
        },
      },
    ],
  ],
}
