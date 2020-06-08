module.exports = {
  title: "Cherry Client",
  tagline: "The Cherry Minecraft 1.14.4 client!",
  url: "https://cherry.rdil.rocks",
  baseUrl: "/",
  favicon: "",
  organizationName: "RDIL",
  projectName: "Cherry",
  themeConfig: {
    navbar: {
      title: "Cherry Client",
      links: [
        {
          to: "docs/features",
          activeBasePath: "docs",
          label: "Features",
          position: "left",
        },
        {
          to: "docs/install",
          activeBasePath: "docs",
          label: "Install",
          position: "left",
        },
        {
          to: "blog",
          label: "Blog",
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
          homePageId: "doc1",
          sidebarPath: require.resolve("./sidebars.js"),
          editUrl: "https://github.com/RDIL/Cherry/edit/master/website/",
          showLastUpdateTime: true,
        },
        blog: {
          showReadingTime: true,
          editUrl: "https://github.com/RDIL/Cherry/edit/master/website/blog/",
          feedOptions: {
            type: "all",
            copyright: "Copyright (c) 2020 Reece Dunham.",
            language: "en-US",
          },
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
